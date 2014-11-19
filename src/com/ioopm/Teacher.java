package com.ioopm;

import java.util.Random;

public class Teacher extends Creature {

    private Course course;

    public Teacher(String name, String roomName) {
        super(name, roomName);
    }

    public void setCourse(Course c) {
        this.course = c;
    }

    public Course getCourse() {
        return this.course;
    }

    public int whichKindOfCreature() {
        return 2;
    }

    public void question(Avatar name) {
        if (name.searchUnfinishedCourses(this.course.toString())) {
            Random n = new Random();
            int randNum = n.nextInt(4);
            if (randNum > 0) {
                if (this.course.question()) {
                    name.addFinishedCourse(this.course.toString());
                    name.updateHP(this.course.getHP());
                }
            }
        }
    }
}