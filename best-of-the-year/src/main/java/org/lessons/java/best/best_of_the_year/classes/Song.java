package org.lessons.java.best.best_of_the_year.classes;

import java.io.Serializable;

public class Song implements Serializable {
    
    private int id;
    private String title;
    private String author;
    private String album;

    public Song() {}

    public Song(int id, String title, String author, String album) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.album = album;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getAlbum() {
        return album;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", title, author, album);
    }
}
