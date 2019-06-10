package br.com.digitalhouse.revisaoesharedprefences.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;

public class FragmentViewPagerModel implements Parcelable {
    private Fragment fragment;
    private String title;

    public FragmentViewPagerModel() {
    }

    public FragmentViewPagerModel(Fragment fragment, String title) {
        this.fragment = fragment;
        this.title = title;
    }

    protected FragmentViewPagerModel(Parcel in) {
        title = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<FragmentViewPagerModel> CREATOR = new Creator<FragmentViewPagerModel>() {
        @Override
        public FragmentViewPagerModel createFromParcel(Parcel in) {
            return new FragmentViewPagerModel(in);
        }

        @Override
        public FragmentViewPagerModel[] newArray(int size) {
            return new FragmentViewPagerModel[size];
        }
    };

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
