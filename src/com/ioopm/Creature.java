package com.ioopm;

public class Creature {
    private String name;
    private Room location;

    public Creature(String name, Room roomName){
        this.name = name;
        this.location = roomName;
    }
    public void changeLocation(Room roomName){
        /*remove from current room*/
        this.location.removeCreature(this);
        /*Change to new location*/
        this.location = roomName;
        /*Adds creature in the new room*/
        location.addCreature(this);
    }

}
