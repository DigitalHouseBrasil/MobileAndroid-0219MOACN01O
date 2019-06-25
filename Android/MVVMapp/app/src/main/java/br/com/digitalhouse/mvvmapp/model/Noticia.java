package br.com.digitalhouse.mvvmapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Noticia implements Parcelable {
    private String title;
    private String date;
    private String description;
    private String author;

    public  Noticia(){

    }

    public Noticia(String title, String date, String description, String author) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.author = author;
    }

    protected Noticia(Parcel in) {
        title = in.readString();
        date = in.readString();
        description = in.readString();
        author = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(date);
        dest.writeString(description);
        dest.writeString(author);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Noticia> CREATOR = new Creator<Noticia>() {
        @Override
        public Noticia createFromParcel(Parcel in) {
            return new Noticia(in);
        }

        @Override
        public Noticia[] newArray(int size) {
            return new Noticia[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
