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
            System.out.println("File not found! aheahidhadha");
        }
    }
    public Room[] readFile() {
        Room[] world = new Room[2];
        /* Bryter av vid "; ", Annars hade vi bara fått med den första delen
         av namnet innan mellanslaget. */
        rooms.useDelimiter("; ");
        //Denna måste vara utanför loopen.
        int x = 0;
        while (rooms.hasNext()) {

            // Testar om nextLine tar hela rumsnamnet fram till ; .
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

            world[x] = new Room(roomName, northConnection, eastConnection, southConnection, westConnection
                    , northLock, eastLock, southLock, westLock);
            x += 1;
        }
        /* Inte säker, men tror att vi måste returna world för
         att komma åt den utanför sedan */
        return world;
    }
    public void closeFile(){
    rooms.close();
    }

    // Lade till makeWorld som gör allt som krävs för att skapa världen.
    public void makeWorld(){
        openFile();
        this.world = readFile();
        closeFile();
    }
}