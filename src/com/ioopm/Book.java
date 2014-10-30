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


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getHP() {
        return HP;
    }
}