package br.com.digitalhouse.mvvmapp;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.ViewOutlineProvider;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.mvvmapp.adapters.RecyclerViewNoticiasAdapter;
import br.com.digitalhouse.mvvmapp.interfaces.RecyclerViewOnItemClickListener;
import br.com.digitalhouse.mvvmapp.model.Noticia;
import br.com.digitalhouse.mvvmapp.viewmodel.NoticiasViewModel;

public class NoticiasActivity extends AppCompatActivity implements RecyclerViewOnItemClickListener {

    private RecyclerView recyclerViewNotidias;
    private ProgressBar progressBar;
    private RecyclerViewNoticiasAdapter adapter;
    private List<Noticia> noticias = new ArrayList<>();
    private NoticiasViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        progressBar = findViewById(R.id.progressBar);
        recyclerViewNotidias = findViewById(R.id.recyclerViewNoticias);
        recyclerViewNotidias.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewNoticiasAdapter(noticias, this);
        recyclerViewNotidias.setHasFixedSize(true);
        recyclerViewNotidias.setAdapter(adapter);

        // Fazer a inicialização do view model
        viewModel = ViewModelProviders.of(this).get(NoticiasViewModel.class);

        // Buscar os dados no repository
        viewModel.buscarNoticias();

        // Adicionar os observables
        viewModel.getNoticiasLiveData().observe(this, noticias -> {
            adapter.update(noticias);
        });


        if (savedInstanceState != null){

        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString("DADO", "TAIRO");
    }

    @Override
    public void onItemClick(Noticia noticia) {
        // Implemnentar o click da noticia
    }
}
