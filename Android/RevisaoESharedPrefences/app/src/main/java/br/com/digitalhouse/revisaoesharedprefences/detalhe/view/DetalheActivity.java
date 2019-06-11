package br.com.digitalhouse.revisaoesharedprefences.detalhe.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.revisaoesharedprefences.R;
import br.com.digitalhouse.revisaoesharedprefences.adapters.ViewPagerDetalheAdapter;
import br.com.digitalhouse.revisaoesharedprefences.home.view.HomeFragment;
import br.com.digitalhouse.revisaoesharedprefences.model.Contato;
import br.com.digitalhouse.revisaoesharedprefences.model.FragmentsDetalheModel;

public class DetalheActivity extends AppCompatActivity {

    private ImageView imageViewContato;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutSenha;
    private ViewPager viewPagerDetalhe;
    private TabLayout tabLayoutDetalhe;

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
        viewPagerDetalhe = findViewById(R.id.viewPagerDetatlhe);
        tabLayoutDetalhe = findViewById(R.id.tabsDetalhes);

        Contato contato = getIntent().getParcelableExtra("CONTATO");

        if (contato != null) {
            textInputLayoutSenha.getEditText().setText(contato.getNome());
            imageViewContato.setImageResource(contato.getImagem());
        }

        ViewPagerDetalheAdapter adapter = new ViewPagerDetalheAdapter(getSupportFragmentManager(), getFramentsList());
        viewPagerDetalhe.setAdapter(adapter);
        viewPagerDetalhe.setOffscreenPageLimit(getFramentsList().size());
        tabLayoutDetalhe.setupWithViewPager(viewPagerDetalhe);
    }

    private List<FragmentsDetalheModel> getFramentsList() {
        List<FragmentsDetalheModel> fragmentsList = new ArrayList<>();
        fragmentsList.add(new FragmentsDetalheModel(new HomeFragment(), "Home"));
        fragmentsList.add(new FragmentsDetalheModel(new HomeFragment(), "Cadastro"));

        return fragmentsList;
    }

}
