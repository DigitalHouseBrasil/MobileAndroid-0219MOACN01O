package com.example.listacontato.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.listacontato.R;
import com.example.listacontato.adapter.ContatoAdapter;
import com.example.listacontato.model.Contatos;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerViewContatos;

    //Declaração da classe adaptadora
    ContatoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewContatos = findViewById(R.id.listaContatosRecyclerView);

        //Inicialização da classe adapter
        adapter = new ContatoAdapter(listaDeContatos());

        //Setando o adapter para o componente recyclerView
        recyclerViewContatos.setAdapter(adapter);

        //Definição do layout da lista utilizando a classe LayoutManager
        recyclerViewContatos.setLayoutManager(new LinearLayoutManager(this));
    }



    //Método que retorna uma lista do tipo Contato
    private List<Contatos> listaDeContatos(){
        List<Contatos> contatos = new ArrayList<>();


        contatos.add(new Contatos("Jessica", "123456"));
        contatos.add(new Contatos("Tairo","34556"));
        contatos.add(new Contatos("Eduardo","097565"));
        contatos.add(new Contatos("Ivan", "675665"));
        contatos.add(new Contatos("Gabriel T.", "546547457"));
        contatos.add(new Contatos("Marcelo", "5546457457"));
        contatos.add(new Contatos("Luca", "456457568"));
        contatos.add(new Contatos("Mayara", "545685686797"));

        return contatos;
    }
}
