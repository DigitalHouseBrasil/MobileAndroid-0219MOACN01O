package br.com.digitalhouse.revisaoesharedprefences.home.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.revisaoesharedprefences.R;
import br.com.digitalhouse.revisaoesharedprefences.adapters.ViewpagerAdapter;
import br.com.digitalhouse.revisaoesharedprefences.model.FragmentViewPagerModel;

public class HomeActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        toolbar = findViewById(R.id.toolbar);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabs);
        setSupportActionBar(toolbar);

        ViewpagerAdapter adapter = new ViewpagerAdapter(getSupportFragmentManager(), getFragmentsViewPager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(getFragmentsViewPager().size());
        tabLayout.setupWithViewPager(viewPager);

    }

    private List<FragmentViewPagerModel> getFragmentsViewPager() {
        List<FragmentViewPagerModel> fragmentViewPagerModels = new ArrayList<>();
        fragmentViewPagerModels.add(new FragmentViewPagerModel(new HomeFragment(), "Home"));
        fragmentViewPagerModels.add(new FragmentViewPagerModel(new HomeFragment(), "Cadastro"));
        fragmentViewPagerModels.add(new FragmentViewPagerModel(new HomeFragment(), "Favoritos"));

        return fragmentViewPagerModels;
    }
}
