package br.com.digitalhouse.revisaoesharedprefences.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import br.com.digitalhouse.revisaoesharedprefences.model.FragmentViewPagerModel;

public class ViewpagerAdapter extends FragmentStatePagerAdapter {

    private List<FragmentViewPagerModel> fragmentViewPagerModels;

    public ViewpagerAdapter(FragmentManager fm, List<FragmentViewPagerModel> fragmentViewPagerModels) {
        super(fm);
        this.fragmentViewPagerModels = fragmentViewPagerModels;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentViewPagerModels.get(position).getFragment();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentViewPagerModels.get(position).getTitle();
    }

    @Override
    public int getCount() {
        return fragmentViewPagerModels.size();
    }
}
