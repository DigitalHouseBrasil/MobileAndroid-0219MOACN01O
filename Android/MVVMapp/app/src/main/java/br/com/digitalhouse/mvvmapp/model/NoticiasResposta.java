package br.com.digitalhouse.mvvmapp.model;

import java.util.List;

public class NoticiasResposta {
    private List<Noticia> noticias;

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
