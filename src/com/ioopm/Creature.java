package com.ioopm;

public class Creature {
    private String name;
    private Room location;

    public Creature(Room location){
        this.name = "The Almighty Sphinx of Eternal Life and Crazy Powers";
        this.location = location;
    }

    public Creature(String name, String roomName){
        this.name = name;
        Room[] rooms = Main.worldCreator.world;
        String[] stringArrayOfRooms = Main.playerAvatar.getRoomList();
        int roomIndex = Main.findIndex(roomName, stringArrayOfRooms);
        this.location = rooms[roomIndex];
        this.location.addCreature(this);

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
