package br.com.digitalhouse.exercicioretrofitapp.data.network;

import br.com.digitalhouse.exercicioretrofitapp.model.PessoasResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("api/")
    Single<PessoasResponse> getPessoas(@Query("results") int total);
}
