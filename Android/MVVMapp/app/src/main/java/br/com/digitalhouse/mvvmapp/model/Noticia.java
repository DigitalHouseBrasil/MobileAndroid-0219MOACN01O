
package br.com.digitalhouse.mvvmapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Noticia {

    @Expose
    @SerializedName("author")
    private String author;

    @Expose
    @SerializedName("date")
    private String date;

    @Expose
    @SerializedName("description")
    private String description;

    @Expose
    @SerializedName("title")
    private String title;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
