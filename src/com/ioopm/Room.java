package com.ioopm;
import java.lang.String;
import java.util.ArrayList;

public class Room{
    private String name;
    private String[] north = new String[2];
    private String[] east = new String[2];
    private String[] south = new String[2];
    private String[] west = new String[2];
    public Room(String name, String northConnection, String eastConnection, String southConnection, String westConnection
    , String northLock, String eastLock, String southLock, String westLock){
        this.name = name;
        north[0] = northConnection;
        east[0] = eastConnection;
        south[0] = southConnection;
        west[0] = eastConnection;
        north[1] = northLock;
        east[1] = eastLock;
        south[1] = southLock;
        west[1] = eastLock;
    }

    // För att skriva ut all info om ett rum
    public void roomInfo(){
        System.out.printf("Roomname : %s \n", this.name );
        System.out.printf("Northdirection, room %s, locked = %s \n", this.north[0], this.north[1]);
        System.out.printf("Eastdirection, room %s, locked = %s \n", this.east[0], this.east[1]);
        System.out.printf("Southdirection, room %s, locked = %s \n", this.south[0], this.south[1]);
        System.out.printf("Westdirection, room %s, locked = %s \n", this.west[0], this.west[1]);
    }
}