package com.ioopm;

public class Student extends Creature{

    private Course course;
    private Book courseBook;

    /**
     *
     * @param name the name of the student
     * @param roomName the name of the room where you want to place the student
     */
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

    /**
     * prints out which course and which book the student has
     */
    public void talk(){
        System.out.printf("I haev diz: %s and I study %s \n", this.courseBook.toString(), this.course.toString());
    }

    /**
     * Desides which kind of creature
     * @return an int to decide which kind of creature
     */
    public int whichKindOfCreature(){
        return 1;
    }

    /**
     * not used here, overrides question in Creature-class
     * @param name the playerAvatar
     */
    public void question(Avatar name){
    }

    /**
     * trades one of playerAvatars books with the students book
     * @param tradeOffer the book you want to offer
     * @return the book you want have
     */
    public Book trade(Book tradeOffer){
        Book returnBook = this.courseBook;
        this.courseBook = tradeOffer;
        return returnBook;

    }
}