package br.com.digitalhouse.mvvmapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class NoticiasResposta {

    @SerializedName("noticias")
    @Expose
    private List<Noticia> noticias = new ArrayList<>();

    /**
     * No args constructor for use in serialization
     */
    public NoticiasResposta() {
    }

    /**
     * @param noticias
     */
    public NoticiasResposta(List<Noticia> noticias) {
        this.noticias = noticias;
    }

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }
}
