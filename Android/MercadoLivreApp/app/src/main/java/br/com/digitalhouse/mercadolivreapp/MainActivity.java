package br.com.digitalhouse.mercadolivreapp;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.mercadolivreapp.adapters.RecyclerViewMercadoLivreAdapter;
import br.com.digitalhouse.mercadolivreapp.model.Result;
import br.com.digitalhouse.mercadolivreapp.viewmodel.MercadoLivreViewModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EditText editTextSearch;
    private RecyclerViewMercadoLivreAdapter adapter;
    private List<Result> results = new ArrayList<>();
    private MercadoLivreViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        viewModel.searchItem("Celular");

        viewModel.getResultLiveData().observe(this, results1 -> adapter.update(results1));
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerview);
        editTextSearch = findViewById(R.id.edit_search);
        viewModel = ViewModelProviders.of(this).get(MercadoLivreViewModel.class);
        adapter = new RecyclerViewMercadoLivreAdapter(results);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
