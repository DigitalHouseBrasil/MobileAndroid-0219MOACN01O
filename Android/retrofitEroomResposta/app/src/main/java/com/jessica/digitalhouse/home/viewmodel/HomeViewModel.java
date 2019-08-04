package com.jessica.digitalhouse.home.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jessica.digitalhouse.model.Movie;
import com.jessica.digitalhouse.model.Result;

import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static androidx.constraintlayout.widget.Constraints.TAG;
import static com.jessica.digitalhouse.database.Database.getDatabase;
import static com.jessica.digitalhouse.network.RetrofitService.getApiService;

public class HomeViewModel extends AndroidViewModel {
    public MutableLiveData<List<Result>> resultsLiveData = new MutableLiveData<>();
    public MutableLiveData<Result> favoriteAdded = new MutableLiveData<>();
    public MutableLiveData<Throwable> resultLiveDataError = new MutableLiveData<>();
    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();

    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public void getMovies(String apikey, String language) {

        disposable.add(
                getApiService().getMovies(apikey, language)
                        //faz a inserção do filme no banco
                        .map(this::salveMovies)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe((Disposable disposable) -> isLoading.setValue(true))
                        .doOnTerminate(() -> isLoading.setValue(false))
                        .subscribe((Movie movieResponse) ->
                                {
                                    resultsLiveData.setValue(movieResponse.getResults());
                                }
                                , throwable -> {
                                    Log.i("LOG", "Error: " + throwable.getMessage());
                                    //Se deu algum erro na requisição mostramos a mensagem de erro e carregamos o dados da base de dados
                                    resultLiveDataError.setValue(throwable);
                                    loadFromDB();
                                })
        );
    }

    private void loadFromDB() {
        disposable.add(
                getDatabase(getApplication()).movieDAO().getAll()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe((Subscription disposable) -> {
                            isLoading.setValue(true);
                        })
                        .doOnTerminate(() -> {
                            isLoading.setValue(false);
                        })
                        .subscribe((List<Result> results) ->
                                        resultsLiveData.setValue(results)
                                , (Throwable throwable) -> {
                                    Log.i("LOG", "Error: " + throwable.getMessage());
                                })
        );
    }

    //método que chama o método de de inserção no banco
    private Movie salveMovies(Movie movie) {
        getDatabase(getApplication()).movieDAO().insert(movie.getResults());
        return movie;
    }

    public void saveFavorite(Result result) {
        // Pegamos a instancia do firebase, objeto necessario para salvar no banco de dados
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        // pegamos a referencia para onde no firebase queremos salvar nossos dados
        DatabaseReference reference = database.getReference("favorites");

        // criamos uma chave unica para o item, assim não haverá conflitos
        String key = reference.push().getKey();

        // setamos o item no caminho da chave criada ex: favorites/kfdhsifyadfhidf/filme
        reference.child(key).setValue(result);

        // Adicionnamos um listener pra sabermos se o item foi salvo no firebase
        reference.child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Result result1 = dataSnapshot.getValue(Result.class);

                // mostamos qe foi salvo nos favoritos
                favoriteAdded.setValue(result1);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Falhou ao ler valor da base do firebase
                resultLiveDataError.setValue(error.toException());
                Log.e(TAG, "Failed to read movie", error.toException());
            }
        });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
