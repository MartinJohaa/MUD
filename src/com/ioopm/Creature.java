package com.ioopm;

/**
 * Created by mj on 11/5/14.
 */
public class Creature {
    private String name;
    private Room location;

    public void setName(String name){
        this.name = name;
    }
    public void setLocation(Room roomName){
        this.location = roomName;
        location.addCreature(this);
    }
}
