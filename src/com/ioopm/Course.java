package com.ioopm;

public class Course {
    private String name;
    private Book literature;
    private int HP;

    public Course(String name, Book literature, int HP){
        this.name = name;
        this.literature = literature;
        this.HP = HP;

    }

    public String toString(){
        return this.name;
    }

    public Book getLiterature(){
        return this.literature;
    }

    /*public Creature getTutor(){
        return this.tutor;
    }*/

    public int getHP(){
        return this.HP;
    }
}