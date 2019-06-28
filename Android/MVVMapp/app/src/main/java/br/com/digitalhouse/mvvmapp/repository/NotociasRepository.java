package br.com.digitalhouse.mvvmapp.repository;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import br.com.digitalhouse.mvvmapp.model.NoticiasResposta;
import io.reactivex.Single;

public class NotociasRepository {

    public Single<NoticiasResposta> obterListaDeNoticiasDoArquivo(Context context) {
        try {

            //Stream para ler o arquivo
            AssetManager manager = context.getAssets();
            InputStream newJson = manager.open("noticias.json");
            BufferedReader bufferedReaderIn = new BufferedReader(new InputStreamReader(newJson));

            //Cria um objeto Gson para analisar o JSON de forma simples
            Gson gson = new Gson();

            //Ultilizando o objeto gson e o métofo fromJson, fazemos a analise do arquivo que temos no bufferedReaderIn, usando como molde a classe "Noticia"
            NoticiasResposta noticiasResposta = gson.fromJson(bufferedReaderIn, NoticiasResposta.class);

            //Retonamos as noticias
            return Single.just(noticiasResposta);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
