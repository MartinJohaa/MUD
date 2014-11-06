package com.ioopm;
import java.lang.String;

public class Book extends Items {
    private String title;
    private String author;
    private int yearOfPublishing;
    public void Book (String title, String author, int yearOfPublishing, int size){
        super.setSize(size);
        this.title = title;
        this.author = author;
    }


    public String getName() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String toString() {
        return (this.title + "by" + this.author);
    }
}