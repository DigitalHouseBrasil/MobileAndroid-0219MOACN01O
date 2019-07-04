package br.com.digitalhouse.mvvmapp;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import br.com.digitalhouse.mvvmapp.adapters.RecyclerViewNoticiasAdapter;
import br.com.digitalhouse.mvvmapp.interfaces.RecyclerViewOnItemClickListener;
import br.com.digitalhouse.mvvmapp.model.Noticia;
import br.com.digitalhouse.mvvmapp.viewmodel.NoticiasViewModel;

public class NoticiasActivity extends AppCompatActivity implements RecyclerViewOnItemClickListener {

    private RecyclerView recyclerViewNotidias;
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView textViewTitle;
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
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        textViewTitle = findViewById(R.id.textViewTitle);
        recyclerViewNotidias = findViewById(R.id.recyclerViewNoticias);
        recyclerViewNotidias.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewNoticiasAdapter(noticias, this);
        recyclerViewNotidias.setHasFixedSize(true);
        recyclerViewNotidias.setAdapter(adapter);

        String title =getString(R.string.title_format, "MVVM Android");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textViewTitle.setText(Html.fromHtml(title, Html.FROM_HTML_MODE_COMPACT));
        } else {
            textViewTitle.setText(Html.fromHtml(title));
        }

        // Fazer a inicialização do view model
        viewModel = ViewModelProviders.of(this).get(NoticiasViewModel.class);

        // Buscar os dados no repository
        viewModel.buscarNoticias();

        // Adicionar os observables
        viewModel.getNoticiasLiveData().observe(this, noticias -> {
            adapter.update(noticias);
        });

        viewModel.getLoadingLiveData().observe(this, isLoading -> {
            if (isLoading) {
                progressBar.setVisibility(View.VISIBLE);
                swipeRefreshLayout.setRefreshing(true);
            } else {
                progressBar.setVisibility(View.GONE);
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        viewModel.getErrorLiveData().observe(this, throwable -> {
            Snackbar.make(recyclerViewNotidias, throwable.getMessage(), Snackbar.LENGTH_SHORT).show();
        });

        swipeRefreshLayout.setOnRefreshListener(() -> {
            viewModel.buscarNoticias();
        });
    }

    @Override
    public void onItemClick(Noticia noticia) {
        // Implemnentar o click da noticia
    }
}
