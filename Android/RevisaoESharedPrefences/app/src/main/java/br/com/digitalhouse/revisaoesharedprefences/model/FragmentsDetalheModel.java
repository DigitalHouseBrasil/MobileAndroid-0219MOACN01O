package br.com.digitalhouse.revisaoesharedprefences.model;

import android.support.v4.app.Fragment;

public class FragmentsDetalheModel {
    private Fragment fragment;
    private String titulo;

    public FragmentsDetalheModel() {
    }

    public FragmentsDetalheModel(Fragment fragment, String titulo) {
        this.fragment = fragment;
        this.titulo = titulo;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
