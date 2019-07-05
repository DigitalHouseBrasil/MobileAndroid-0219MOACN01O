package br.com.digitalhouse.mercadolivreapp.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.digitalhouse.mercadolivreapp.model.MercadoLivreResponse;
import br.com.digitalhouse.mercadolivreapp.model.Result;
import br.com.digitalhouse.mercadolivreapp.repository.MercadoLivreRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static br.com.digitalhouse.mercadolivreapp.util.AppUtil.isNetworkConnected;

public class MercadoLivreViewModel extends AndroidViewModel {

    private MutableLiveData<List<Result>> resultLiveData = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private MercadoLivreRepository repository = new MercadoLivreRepository();

    public MercadoLivreViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Result>> getResultLiveData() {
        return resultLiveData;
    }

    // Ao buscar o item verificamos se estamos conectados ou não
    public void searchItem(String item) {
        if (isNetworkConnected(getApplication())) {
            getFromNetwork(item);
        } else {
            getFromLocal();
        }
    }

    private void getFromLocal() {

        // Adicionamos a chamada a um disposible para podermos eliminar o disposable da destruição do viewmodel

    }

    private void getFromNetwork(String item) {

        // Adicionamos a chamada a um disposible para podermos eliminar o disposable da destruição do viewmodel

        //Salvar os items quando tivermos buscado

    }

    public MercadoLivreResponse saveItems(MercadoLivreResponse mercadoLivreResponse) {

    }

    // Limpa as chamadas que fizemos no RX
    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
