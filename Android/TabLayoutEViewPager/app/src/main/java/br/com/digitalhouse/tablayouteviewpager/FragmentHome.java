package br.com.digitalhouse.tablayouteviewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

/**
 * A placeholder fragment containing a simple view.
 */
public class FragmentHome extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public static FragmentHome newInstance(String title) {

        FragmentHome fragment = new FragmentHome();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_SECTION_NUMBER, title);
        fragment.setArguments(bundle);

        return fragment;
    }


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_main, container, false);

        final TextView textView = root.findViewById(R.id.section_label);

        String title = getArguments().getString(ARG_SECTION_NUMBER);

        textView.setText(title);

        return root;
    }
}