package com.ioopm;

import java.util.Random;

public class Teacher extends Creature {

    private Course course;

    /**
     *
     * @param name the name of the teacher
     * @param roomName the room you want to place the teacher
     */
    public Teacher(String name, String roomName) {
        super(name, roomName);
    }

    public void setCourse(Course c) {
        this.course = c;
    }

    public Course getCourse() {
        return this.course;
    }

    /**
     * Desides which kind of creature
     * @return an int to decide which kind of creature
     */
    public int whichKindOfCreature() {
        return 2;
    }

    /**
     * Asks the question for the teachers course
     * @param name the playerAvatar
     */
    public void question(Avatar name) {
        if (name.searchUnfinishedCourses(this.course.toString())) {
            Random n = new Random();
            int randNum = n.nextInt(4);
            if (randNum > 0) {
                if (this.course.question(name)) {
                    System.out.println("High five! I'll report your result to UpDok immediately!");
                    name.addFinishedCourse(this.course.toString());
                    name.updateHP(this.course.getHP());
                }
            }
        }else if(name.searchFinishedCourses(this.course.toString())){
            Random n = new Random();
            int randNum = n.nextInt(2);
            if (randNum > 0) {
                if (this.course.question(name)) {
                    System.out.println("Nice, you remembered!");
                }else{
                    System.out.println("Looks like you have to enroll this course again!");
                    name.addUnfinishedCourse(this.course.toString());
                    name.removeFinishedCourse(this.course.toString());
                    name.updateHP(-(this.course.getHP()));
                }
            }
        }
    }

    /**
     * Full of crap. Had to override trade in Creature
     * @param tradeOffer the book you want to trade
     * @return the book you want
     */
    public Book trade(Book tradeOffer){
        Book mumboJumbo = new Book("Skit", "ErikBallarUr", 2045, 500);
        return mumboJumbo;
    }
}