package br.com.digitalhouse.mvvmapp.repository;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import br.com.digitalhouse.mvvmapp.data.network.ApiService;
import br.com.digitalhouse.mvvmapp.model.NoticiasResposta;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.functions.Consumer;

public class NoticiasRepository {

    public Single<NoticiasResposta> obterListaNoticiasDoArquivo(Context context) {
        try {
            AssetManager manager = context.getAssets();
            InputStream newJson = manager.open("noticias.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(newJson));

            Gson gson = new Gson();

            NoticiasResposta resposta = gson.fromJson(reader, NoticiasResposta.class);

            return Single.just(resposta);

        } catch (IOException e) {
            e.printStackTrace();
            return Single.error(e);
        }
    }

    public Single<NoticiasResposta> obterListaNoticiasInternet(){
        return ApiService.getApiService().getNoticias();
    }
}
