package com.ioopm;
import java.lang.String;
import java.util.ArrayList;

public class Room{
    /**
     * creating variables for the different elements of a room
     */
    private String name;
    private String[] north = new String[2];
    private String[] east = new String[2];
    private String[] south = new String[2];
    private String[] west = new String[2];

    /**
     * The constructor which creates a room-object
     * @param name the name of the room
     * @param northConnection the name of the room to the north, if there is one
     * @param eastConnection -"- east -"-
     * @param southConnection -"- south -"-
     * @param westConnection -"- west -"-
     * @param northLock information about whether the north door is locked or not
     * @param eastLock -"- east -"-
     * @param southLock -"- south -"-
     * @param westLock -"- west -"-
     */
    public Room(String name, String northConnection, String eastConnection, String southConnection, String westConnection
    , String northLock, String eastLock, String southLock, String westLock){
        this.name = name;
        north[0] = northConnection;
        east[0] = eastConnection;
        south[0] = southConnection;
        west[0] = westConnection;
        north[1] = northLock;
        east[1] = eastLock;
        south[1] = southLock;
        west[1] = westLock;
    }

    // För att skriva ut all info om ett rum
    public void roomInfo(){
        System.out.printf("Roomname : %s \n", this.name );
        System.out.printf("Northdirection, room: %s, locked = %s \n", this.north[0], this.north[1]);
        System.out.printf("Eastdirection, room: %s, locked = %s \n", this.east[0], this.east[1]);
        System.out.printf("Southdirection, room: %s, locked = %s \n", this.south[0], this.south[1]);
        System.out.printf("Westdirection, room: %s, locked = %s \n", this.west[0], this.west[1]);
        System.out.print("\n");
    }
    public boolean isOpen(String direction){
        switch (direction){
            case "North":
                if (this.north[1].equals("True")){
                    return true;
                }else{ return false;}
            case "East":
                if (this.east[1].equals("True")){
                    return true;
                }else{ return false;}
            case "South":
                if (this.south[1].equals("True")){
                    return true;
                }else{ return false;}
            case "West":
                if (this.west[1].equals("True")){
                    return true;
                }else{ return false;}
            default:
                System.out.println("Valid options are: North, East, South, West!");
                return false;
        }

    }
}