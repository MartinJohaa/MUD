package com.ioopm;

import java.util.ArrayList;

public class Course {
    private String name;
    private Book literature;
    private ArrayList<Creature> tutorAndStudents = new ArrayList<>();
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