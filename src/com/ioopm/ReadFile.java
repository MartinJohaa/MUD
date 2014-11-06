package com.ioopm;
import java.io.*;
//import java.io.IOException;
import java.lang.System;
import java.util.*;

public class ReadFile {
    /****************************ROOMS********************************************/
    private Scanner rooms;
    // Lade till world variabel här ute så vi kommer åt den utifrån.
    public Room[] world;
    public void openRoomFile(){
        try{
            rooms = new Scanner(new File("rooms.txt"));
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("File not found! check rooms.txt");
        }
    }
    public Room[] readRoomFile() {
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
    public void closeRoomFile(){
    rooms.close();
    }

    /**
     * this method creates the world in which the game is set
     */
    public void makeWorld(){
        openRoomFile();
        this.world = readRoomFile();
        closeRoomFile();
    }
    /****************************CREATURES****************************************/
    private Scanner creatureScanner;
    // Lade till world variabel här ute så vi kommer åt den utifrån.
    public Creature[] creatures;
    public void openCreatureFile(){
        try{
            creatureScanner = new Scanner(new File("creatures.txt"));
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("File not found! check creatures.txt");
        }
    }
    public Creature[] readCreatureFile() {
        /**
         *  Creating an array which is filled with creature-objects
         */
        creatures = new Creature[1];
        /**
         *  Separates the segments at "; " instead of just a blankspace
         */
        creatureScanner.useDelimiter(";");
        /**
         * variable to increase index of world (the array the rooms are written to)
         */
        int x = 0;
        while (creatureScanner.hasNext()) {
            /**
             * Puts the info from the different segments in a line from rooms.txt
             * to variables
             */
            String name = creatureScanner.next();
            if (creatureScanner.next().equals("Teacher")){
                /*creatures[x] = new Teacher(name);*/
            }else if (creatureScanner.next().equals("Student")){
                /*creatures[x] = new Student(name);*/
            }
            x += 1;
        }
        return creatures;
    }
    public void closeCreatureFile(){
        creatureScanner.close();
    }
    public void makeCreatures(){
        openCreatureFile();
        this.creatures = readCreatureFile();
        closeCreatureFile();
    }

    /****************************BOOKS********************************************/

    private Scanner bookScan;
    public Book[] booksInWorld;
    public void openBookFile(){
        try{
            bookScan = new Scanner(new File("books.txt"));
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("File not found! check books.txt");
        }
    }

    public Book[] readBookFile(){
        booksInWorld = Book[6];
        bookScan.useDelimiter(";");
        int x = 0;
        while (bookScan.hasNext()){
            String title = bookScan.next();
            String author = bookScan.next();
            int yearOfPublishing = bookScan.nextInt();
            int bookSize = bookScan.nextInt();
            booksInWorld[x] = new Book(title, author, yearOfPublishing, bookSize);
            x += 1;
        }
        return booksInWorld;
    }

    public void closeBookFile(){
        bookScan.close();
    }

    public void makeBooks(){
        openBookFile();
        this.booksInWorld = readBookFile();
        closeBookFile();
    }
}