package br.com.digitalhouse.tablayouteviewpager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.tablayouteviewpager.model.FragmentModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<FragmentModel> fragmentModels = new ArrayList<>();
        fragmentModels.add(new FragmentModel("Home", FragmentHome.newInstance("Home")));
        fragmentModels.add(new FragmentModel("Home 2", FragmentHome.newInstance("Home 2")));
        fragmentModels.add(new FragmentModel("Home 3", FragmentHome.newInstance("Home 3")));

        HomeFragmentPagerAdapter homeFragmentPagerAdapter = new HomeFragmentPagerAdapter(getSupportFragmentManager(), fragmentModels);

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(homeFragmentPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        viewPager.setOffscreenPageLimit(fragmentModels.size());
        tabs.setupWithViewPager(viewPager);
    }
}