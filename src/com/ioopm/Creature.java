package com.ioopm;

public class Creature {
    private String name;
    private Room location;
    private Course course;

    public Creature(String name, String roomName, String course){
        this.name = name;
        Room[] rooms = Main.worldCreator.world;
        String[] stringArrayOfRooms = Main.playerAvatar.getRoomList();
        int roomIndex = Main.findIndex(roomName, stringArrayOfRooms);
        this.location = rooms[roomIndex];
        this.location.addCreature(this);
        String[] stringCourseList = Main.courseCreator.stringCourseList();
        int i = Main.findIndex(course, stringCourseList);
        this.course = Main.courseCreator.courseList[i];

    }
    public void changeLocation(Room roomName){
        /*remove from current room*/
        this.location.removeCreature(this);
        /*Change to new location*/
        this.location = roomName;
        /*Adds creature in the new room*/
        location.addCreature(this);
    }

    public String toString(){
        return this.name;
    }
}
