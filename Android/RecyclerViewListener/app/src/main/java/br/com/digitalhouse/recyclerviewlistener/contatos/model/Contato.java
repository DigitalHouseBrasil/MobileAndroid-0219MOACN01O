package br.com.digitalhouse.recyclerviewlistener.contatos.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Contato implements Parcelable {
    private String nome;
    private String numero;
    private int foto;

    public Contato() {
    }

    public Contato(String nome, String numero, int foto) {
        this.nome = nome;
        this.numero = numero;
        this.foto = foto;
    }

    protected Contato(Parcel in) {
        nome = in.readString();
        numero = in.readString();
        foto = in.readInt();
    }

    public static final Creator<Contato> CREATOR = new Creator<Contato>() {
        @Override
        public Contato createFromParcel(Parcel in) {
            return new Contato(in);
        }

        @Override
        public Contato[] newArray(int size) {
            return new Contato[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nome);
        parcel.writeString(numero);
        parcel.writeInt(foto);
    }
}
