package br.com.digitalhouse.mvvmapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import br.com.digitalhouse.mvvmapp.model.NoticiasResposta;
import br.com.digitalhouse.mvvmapp.repository.NotociasRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class NoticiasViewModel extends AndroidViewModel {

    private MutableLiveData<NoticiasResposta> noticiasRespostaLiveData = new MutableLiveData<>();
    private MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private NotociasRepository repository = new NotociasRepository();

    public NoticiasViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<NoticiasResposta> getNoticiasResposta() {
        return noticiasRespostaLiveData;
    }

    public void buscarNoticias() {
        disposable.add(repository.obterListaDeNoticiasDoArquivo(getApplication().getApplicationContext())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(noticiasResposta -> {
                    noticiasRespostaLiveData.setValue(noticiasResposta);
                }, throwable -> {
                    errorLiveData.setValue(throwable);
                }));
    }
}
