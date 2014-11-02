package com.ioopm;
import java.util.ArrayList;

class Avatar{
    private String[] roomList = {
            "Room 1357", "Hallway 4"
    };
    private Room currentLocation;
    private String name;
    private ArrayList<String> unfinishedCourses = new ArrayList<String>();
    private ArrayList<String> finishedCourses = new ArrayList<String>();
    private int HP = 60;
    public Avatar(String name){
        this.name = name;
    }
    public String getName(){
	return name;
    }
    public void addFinishedCourse(String courseName){
	finishedCourses.add(courseName);
    }
    public void addUnfinishedCourse(String course){
	unfinishedCourses.add(course);
    }
    public void updateHP(int points){
	HP += points;
    }
    public void printList(){
	int length = finishedCourses.size();
	System.out.print("You have completed the following courses: ");
	for (int i = 0;i<(length-1);i++){
	    System.out.printf("%s, ", finishedCourses.get(i));
	}
	System.out.printf("%s\n", finishedCourses.get(length-1));
    }
    //public void finishCourse, hanterar metoder ovan och examinerar kurs
    public void setCurrentLocation(String roomname){
    int index = Main.findIndex(roomname, roomList);
    this.currentLocation = Main.creator.world[index];
    }

}
