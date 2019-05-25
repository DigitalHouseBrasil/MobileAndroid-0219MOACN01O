package br.com.digitalhouse.comunicacoentrefragments.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.com.digitalhouse.comunicacoentrefragments.R;
import br.com.digitalhouse.comunicacoentrefragments.interfaces.Comunicador;
import br.com.digitalhouse.comunicacoentrefragments.model.Person;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    private Comunicador comunicador;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            comunicador = (Comunicador) context;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        Button btnSend = view.findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Colocar o envio de dados
                Person person = new Person("Tairo", "Professor", 30);
                comunicador.receberMensagem(person);
            }
        });

        return view;
    }
}
