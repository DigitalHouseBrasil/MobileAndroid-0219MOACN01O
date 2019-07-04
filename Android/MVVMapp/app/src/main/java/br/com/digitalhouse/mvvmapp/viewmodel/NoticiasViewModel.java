package br.com.digitalhouse.mvvmapp.viewmodel;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import br.com.digitalhouse.mvvmapp.model.Noticia;
import br.com.digitalhouse.mvvmapp.repository.NoticiasRepository;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class NoticiasViewModel extends AndroidViewModel {

    private MutableLiveData<List<Noticia>> noticiasLiveData = new MutableLiveData<>();
    private MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> loadingLiveData = new MutableLiveData<>();

    private CompositeDisposable disposable = new CompositeDisposable();
    private NoticiasRepository repository = new NoticiasRepository();

    public NoticiasViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Noticia>> getNoticiasLiveData() {
        return noticiasLiveData;
    }

    public LiveData<Boolean> getLoadingLiveData() {
        return loadingLiveData;
    }

    public LiveData<Throwable> getErrorLiveData() {
        return errorLiveData;
    }

    public void buscarNoticias() {

        /*if (AppUtil.isNetworkConnected(getApplication().getApplicationContext())){

        }*/

        disposable.add(

                Single.concat(
                        repository.obterListaNoticiasDoArquivo(getApplication().getApplicationContext()),
                        repository.obterListaNoticiasInternet())
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loadingLiveData.setValue(true))
                        .doAfterTerminate(() -> loadingLiveData.setValue(false))
                        .subscribe(noticiasResposta -> {
                            noticiasLiveData.setValue(noticiasResposta.getNoticias());
                        }, throwable -> {
                            errorLiveData.setValue(throwable);
                        })
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
