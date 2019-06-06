package br.com.digitalhouse.revisaoesharedprefences.home.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.revisaoesharedprefences.R;
import br.com.digitalhouse.revisaoesharedprefences.adapters.RecyclerViewContatosAdapter;
import br.com.digitalhouse.revisaoesharedprefences.detalhe.view.DetalheActivity;
import br.com.digitalhouse.revisaoesharedprefences.interfaces.RecyclerViewClickListener;
import br.com.digitalhouse.revisaoesharedprefences.model.Contato;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements RecyclerViewClickListener {


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // Add findViewById para recycler
        RecyclerView recyclerViewContatos = view.findViewById(R.id.recyclerViewContatos);

        // Configurar recyclerview e adapater
        RecyclerViewContatosAdapter adapter = new RecyclerViewContatosAdapter(getContatos(), this);

        recyclerViewContatos.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewContatos.setAdapter(adapter);

        return view;
    }

    // REtorna lista de contatos para recycleriew
    private List<Contato> getContatos() {
        List<Contato> contatos = new ArrayList<>();
        contatos.add(new Contato("Tairo", "11-91111-1111", R.drawable.trasformers));
        contatos.add(new Contato("Jessica", "11-91111-1111", R.drawable.android));
        contatos.add(new Contato("Jair", "11-91111-1111", R.drawable.trasformers));
        contatos.add(new Contato("Vinicius", "11-91111-1111", R.drawable.android));
        contatos.add(new Contato("Eduardo", "11-91111-1111", R.drawable.trasformers));
        contatos.add(new Contato("Ivan", "11-91111-1111", R.drawable.android));

        return contatos;
    }

    // Método para escutar evento de click em recyclerview
    @Override
    public void onClick(Contato contato) {
        Intent intent = new Intent(getContext(), DetalheActivity.class);
        intent.putExtra("CONTATO", contato);
        startActivity(intent);
    }
}
