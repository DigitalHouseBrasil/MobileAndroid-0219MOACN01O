package br.com.digitalhouse.revisaoesharedprefences.detalhe.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import br.com.digitalhouse.revisaoesharedprefences.R;
import br.com.digitalhouse.revisaoesharedprefences.model.Contato;

public class DetalheActivity extends AppCompatActivity {

    private ImageView imageViewContato;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmail);
        textInputLayoutSenha = findViewById(R.id.textInputLayoutSenha);
        imageViewContato = findViewById(R.id.circleImageViewFoto);

        Contato contato = getIntent().getParcelableExtra("CONTATO");

        if (contato != null){
            textInputLayoutSenha.getEditText().setText(contato.getNome());
            imageViewContato.setImageResource(contato.getImagem());
        }
    }

}
