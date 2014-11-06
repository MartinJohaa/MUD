package com.ioopm;
import java.lang.String;

public class Book extends Items {
    private String title;
    private String author;
    private int HP;
    public void Book (int size, String title, String author, int HP){
        setSize(size);
        this.title = title;
        this.author = author;
        this.HP = HP;
    }


    public String getName() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getHP() {
        return this.HP;
    }

    public String toString() {
        return (this.title + "by" + this.author);
    }
}