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
        this.location = roomName;
        location.addCreature(this);
    }

}
