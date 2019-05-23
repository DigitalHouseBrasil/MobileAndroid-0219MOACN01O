package br.com.digitalhouse.fragmentsapp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.com.digitalhouse.fragmentsapp.R;

public class Fragmento1 extends Fragment {

    /* Construtor vazio obrigatório*/
    public Fragmento1() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflamos a o xml dentro de um objeto view
        View view = inflater.inflate(R.layout.fragment_1, container, false );

        // linkamos o botão com o xml
        Button btnMessage = view.findViewById(R.id.btnMessage);

        //Setamos o evento de click no botão
        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Mostramos a Snackbar na tela
                Snackbar.make(view, "Botão clicado", Snackbar.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
