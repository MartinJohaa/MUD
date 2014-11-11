package com.ioopm;

public class Teacher extends Creature{

    private Course course;

    public Teacher(String name, String roomName){
        super(name, roomName);
    }

    public void setCourse(Course c){
        this.course = c;
    }
    public Course getCourse(){
        return this.course;
    }
}