package com.jessica.digitalhouse.home.view;

import androidx.lifecycle.ViewModelProviders;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.snackbar.Snackbar;
import com.jessica.digitalhouse.R;
import com.jessica.digitalhouse.adapters.RecyclerViewAdapter;
import com.jessica.digitalhouse.favorites.view.FavoritesActivity;
import com.jessica.digitalhouse.interfaces.FavoriteItemClick;
import com.jessica.digitalhouse.interfaces.RecyclerViewClick;
import com.jessica.digitalhouse.model.Result;
import com.jessica.digitalhouse.home.viewmodel.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewClick, FavoriteItemClick {

    private RecyclerView recyclerView;
    private TextView textViewFavoritos;
    private List<Result> results = new ArrayList<>();
    private HomeViewModel viewModel;
    private int pag = 1;
    private int totalpag = 10;
    private ProgressBar progressBar;
    private RecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        textViewFavoritos.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, FavoritesActivity.class));
        });

        //recyclerView em modo Grid
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);

        //setando a nova lista para o adapter do recyclerView
        viewModel.getMovies("e1a9eef62eef24833db25f0491f893c7", "PT-BR");
        viewModel.resultsLiveData.observe(this, (List<Result> results) -> {
            adapter.setResult(results);
        });

        //mudando a visibilidade da barra de progresso de acordo com o retorno do isLoading
        viewModel.isLoading.observe(this, (Boolean loading) -> {
            if (loading){
                progressBar.setVisibility(View.VISIBLE);
            }else{
                progressBar.setVisibility(View.GONE);
            }
        });

        viewModel.favoriteAdded.observe(this, result -> {
            if (result != null) {
                Snackbar.make(recyclerView, result.getTitle() + " Adicionado as favoritos", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    // Inicializa as Views
    private void initViews() {
        recyclerView = findViewById(R.id.recyclerview);
        progressBar = findViewById(R.id.progress_bar);
        textViewFavoritos = findViewById(R.id.textFavorites);
        adapter = new RecyclerViewAdapter(results, this, this);
        viewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
    }

    @Override
    public void clickListenner(Result result) {
        long id = result.getId();
        Toast.makeText(this, "ID "+result.getId(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void removeFavoriteClickListener(Result result) {
        viewModel.saveFavorite(result);
    }
}
