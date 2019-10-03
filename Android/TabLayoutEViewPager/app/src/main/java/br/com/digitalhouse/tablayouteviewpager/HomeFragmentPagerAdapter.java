package br.com.digitalhouse.tablayouteviewpager;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

import br.com.digitalhouse.tablayouteviewpager.model.FragmentModel;

public class HomeFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private List<FragmentModel> fragmentModels;

    public HomeFragmentPagerAdapter(FragmentManager fm, List<FragmentModel> fragmentModels) {
        super(fm);
        this.fragmentModels = fragmentModels;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentModels.get(position).getFragment();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentModels.get(position).getTitle();
    }

    @Override
    public int getCount() {
        return fragmentModels.size();
    }
}