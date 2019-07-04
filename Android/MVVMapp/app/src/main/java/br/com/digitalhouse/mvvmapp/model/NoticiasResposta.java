
package br.com.digitalhouse.mvvmapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NoticiasResposta {

    @Expose
    @SerializedName("noticias")
    private List<Noticia> noticias;

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }

}
