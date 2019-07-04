package br.com.digitalhouse.mvvmapp.data.network;

import br.com.digitalhouse.mvvmapp.model.NoticiasResposta;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface Api {

    @GET("bins/vfvxn")
    Single<NoticiasResposta> getNoticias();
}
