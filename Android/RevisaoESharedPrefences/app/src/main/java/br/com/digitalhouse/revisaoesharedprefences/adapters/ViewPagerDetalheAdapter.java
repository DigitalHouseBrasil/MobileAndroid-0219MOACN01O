package br.com.digitalhouse.revisaoesharedprefences.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import br.com.digitalhouse.revisaoesharedprefences.model.FragmentsDetalheModel;

public class ViewPagerDetalheAdapter extends FragmentStatePagerAdapter {

    private List<FragmentsDetalheModel> fragmentsDetalheModels;

    public ViewPagerDetalheAdapter(FragmentManager fm, List<FragmentsDetalheModel> fragmentsDetalheModels) {
        super(fm);
        this.fragmentsDetalheModels = fragmentsDetalheModels;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentsDetalheModels.get(position).getFragment();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentsDetalheModels.get(position).getTitulo();
    }

    @Override
    public int getCount() {
        return fragmentsDetalheModels.size();
    }
}
