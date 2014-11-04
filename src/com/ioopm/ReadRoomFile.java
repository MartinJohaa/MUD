package com.ioopm;
import java.io.*;
//import java.io.IOException;
import java.lang.System;
import java.util.*;

public class ReadRoomFile{
    private Scanner rooms;
    // Lade till world variabel här ute så vi kommer åt den utifrån.
    public Room[] world;
    public void openFile(){
        try{
            rooms = new Scanner(new File("rooms.txt"));
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("File not found! check rooms.txt");
        }
    }
    public Room[] readFile() {
        /**
         *  Creating an array which is filled with room-objects
         */
        world = new Room[19];
        /**
         *  Separates the segments at "; " instead of just a blankspace
         */
        rooms.useDelimiter("; ");
        /**
         * variable to increase index of world (the array the rooms are written to)
         */
        int x = 0;
        while (rooms.hasNext()) {
            /**
             * Puts the info from the different segments in a line from rooms.txt
             * to variables
             */
            String roomName = rooms.next();
            String northConnection = rooms.next();
            String eastConnection = rooms.next();
            String southConnection = rooms.next();
            String westConnection = rooms.next();
            String northLock = rooms.next();
            String eastLock = rooms.next();
            String southLock = rooms.next();
            String westLock = rooms.nextLine(); // Fråga ass!!
            westLock = westLock.substring(2, westLock.length());

            /**
             * Creating an array to which the rooms are written
             */
            world[x] = new Room(roomName, northConnection, eastConnection, southConnection, westConnection
                    , northLock, eastLock, southLock, westLock);
            x += 1;
        }
        return world;
    }
    public void closeFile(){
    rooms.close();
    }

    /**
     * this method creates the world in which the game is set
     */
    public void makeWorld(){
        openFile();
        this.world = readFile();
        closeFile();
    }
}