package com.ioopm;
import java.io.File;
import java.io.IOException;
import java.lang.System;
import java.util.Scanner;

public class ReadRoomFile{
    private Scanner rooms;
    public void openFile(){
        try{
            rooms = new Scanner(new File("rooms.txt"));
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("File not found! ");
        }
    }
    public void readFile(){
        Room[] world = new Room[2];
        while (rooms.hasNext()){
            int x = 0;
            String roomName = rooms.next();
            roomName = roomName.substring(0,roomName.length());
            String northConnection = rooms.next();
            northConnection = northConnection.substring(0,northConnection.length());
            String eastConnection = rooms.next();
            eastConnection = eastConnection.substring(0,eastConnection.length());
            String southConnection = rooms.next();
            southConnection = southConnection.substring(0,southConnection.length());
            String westConnection = rooms.next();
            westConnection = westConnection.substring(0,westConnection.length());
            String northLock = rooms.next();
            northLock = northLock.substring(0,northLock.length());
            String eastLock = rooms.next();
            eastLock = eastLock.substring(0,eastLock.length());
            String southLock = rooms.next();
            southLock = southLock.substring(0,southLock.length());
            String westLock = rooms.next();
            westLock = westLock.substring(0,westLock.length());
            world[x] = new Room(roomName, northConnection, eastConnection, southConnection, westConnection
            , northLock, eastLock, southLock, westLock);
            x += 1;
        }
    }
}