package com.ioopm;

public class Student extends Creature{

    private Course course;
    private Book courseBook;

    public Student(String name, String roomName){
        super(name, roomName);
    }

    public void setCourse(Course c){
        this.course = c;
    }
    public Course getCourse(){
        return this.course;
    }

    public void setCourseBook(Book b){
        this.courseBook = b;
    }
    public Book getCourseBook(){
        return this.courseBook;
    }

    public void talk(){
        System.out.printf("I haev diz: %s!\n", this.courseBook.toString());
    }
}