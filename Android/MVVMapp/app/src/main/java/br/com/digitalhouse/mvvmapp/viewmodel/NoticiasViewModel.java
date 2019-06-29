package br.com.digitalhouse.mvvmapp.viewmodel;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import br.com.digitalhouse.mvvmapp.model.Noticia;

public class NoticiasViewModel extends AndroidViewModel {

    private MutableLiveData<List<Noticia>> noticiasLiveData = new MutableLiveData<>();

    public NoticiasViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Noticia>> getNoticiasLiveData(){
        return  noticiasLiveData;
    }

    public void buscarNoticias(){

        List<Noticia> noticias = new ArrayList<>();
        noticias.add( new Noticia(
                "Bolssonaro com drogas no avião",
                "28/06/2019",
                "Não sei se é versade isso não",
                "uol"));
        noticias.add( new Noticia(
                "Bolssonaro com drogas no avião",
                "28/06/2019",
                "Não sei se é versade isso não",
                "uol"));
        noticias.add( new Noticia(
                "Bolssonaro com drogas no avião",
                "28/06/2019",
                "Não sei se é versade isso não",
                "uol"));
        noticias.add( new Noticia(
                "Bolssonaro com drogas no avião",
                "28/06/2019",
                "Não sei se é versade isso não",
                "uol"));
        noticias.add( new Noticia(
                "Bolssonaro com drogas no avião",
                "28/06/2019",
                "Não sei se é versade isso não",
                "uol"));
        noticias.add( new Noticia(
                "Bolssonaro com drogas no avião",
                "28/06/2019",
                "Não sei se é versade isso não",
                "uol"));
        noticias.add( new Noticia(
                "Bolssonaro com drogas no avião",
                "28/06/2019",
                "Não sei se é versade isso não",
                "uol"));

        noticiasLiveData.setValue(noticias);
    }
}
