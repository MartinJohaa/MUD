package com.ioopm;
import java.lang.String;

public class Book extends Item {
    private String title;
    private String author;
    private int yearOfPublishing;

    /**
     * Creates a Book-object with a title, an author
     * year-of-publishing and size
     * @param title name of the book
     * @param author the author's name
     * @param yearOfPublishing int representing publishing year
     * @param size int representing the book's size
     */
    public Book (String title, String author, int yearOfPublishing, int size){
        super(size);
        this.title = title;
        this.author = author;
    }


    public String getName() {
        return this.title;
    }

    public String toString() {
        return ("\"" + this.title + "\"" + " by " + this.author);
    }
}