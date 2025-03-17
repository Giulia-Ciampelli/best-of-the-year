package org.lessons.java.best.best_of_the_year.classes;

import java.io.Serializable;

public class Movie implements Serializable {
    
    private int id;
    private int length;
    private String title;
    private String description;

    public Movie() {}

    public Movie(int id, String title, int length, String description) {
        this.id = id;
        this.title = title;
        this.length = length;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%s, %d, %s", title, length, description);
    }
}
