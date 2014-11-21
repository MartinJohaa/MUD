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
        System.out.printf("I haev diz: %s and I study %s \n", this.courseBook.toString(), this.course.toString());
    }

    public int whichKindOfCreature(){
        return 1;
    }

    public void question(Avatar name){
    }

    public Book trade(Book tradeOffer){
        Book returnBook = this.courseBook;
        this.courseBook = tradeOffer;
        return returnBook;

    }
}