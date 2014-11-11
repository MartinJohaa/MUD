package com.ioopm;
import java.io.*;
//import java.io.IOException;
import java.lang.System;
import java.util.*;

public class ReadFile {
    /**
     * *************************ROOMS*******************************************
     */
    private Scanner rooms;
    // Lade till world variabel här ute så vi kommer åt den utifrån.
    public Room[] world;

    public void openRoomFile() {
        try {
            rooms = new Scanner(new File("rooms.txt"));
        } catch (IOException e) {
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

    public void closeRoomFile() {
        rooms.close();
    }

    /**
     * this method creates the world in which the game is set
     */
    public void makeWorld() {
        openRoomFile();
        this.world = readRoomFile();
        closeRoomFile();
    }

    /**
     * *************************CREATURES***************************************
     */
    private Scanner creatureScanner;
    // Lade till world variabel här ute så vi kommer åt den utifrån.
    public Creature[] creatures;

    public void openCreatureFile() {
        try {
            creatureScanner = new Scanner(new File("creatures.txt"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not found! check creatures.txt");
        }
    }

    public Creature[] readCreatureFile() {
        /**
         *  Creating an array which is filled with creature-objects
         */
        creatures = new Creature[8];
        /**
         *  Separates the segments at "; " instead of just a blankspace
         */
        creatureScanner.useDelimiter(";");
        /**
         * variable to increase index of (the array the objects are written to)
         */
        int x = 0;
        int y = 0;
        int z = 0;
        while (creatureScanner.hasNext()) {
            /**
             * Puts the info from the different segments in a line from creatures.txt
             * to variables
             */
            String name = creatureScanner.next();
            String room = creatureScanner.next();
            String kind = creatureScanner.nextLine();
            kind = kind.substring(1, kind.length());
            if (kind.equals("Student")) {
                creatures[x] = new Student(name, room);
                Main.students[z] = creatures [x];
                z++;
            } else if (kind.equals("Teacher")) {
                creatures[x] = new Teacher(name, room);
                Main.tutors[y] = creatures[x];
                y++;
            }
            x += 1;
        }
        return creatures;
    }

    public void closeCreatureFile() {
        creatureScanner.close();
    }

    public void makeCreatures() {
        openCreatureFile();
        this.creatures = readCreatureFile();
        closeCreatureFile();
    }

    /**
     * *************************BOOKS*******************************************
     */

    private Scanner bookScan;
    public Book[] booksInWorld;

    public void openBookFile() {
        try {
            bookScan = new Scanner(new File("books.txt"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not found! check books.txt");
        }
    }

    public Book[] readBookFile() {
        booksInWorld = new Book[8];
        bookScan.useDelimiter(";");
        int x = 0;
        while (bookScan.hasNext()) {
            String title = bookScan.next();
            String author = bookScan.next();
            int yearOfPublishing = bookScan.nextInt();
            String bookSizeString = bookScan.nextLine();
            bookSizeString = bookSizeString.substring(1);
            int bookSize = Integer.parseInt(bookSizeString);
            booksInWorld[x] = new Book(title, author, yearOfPublishing, bookSize);
            x += 1;
        }
        return booksInWorld;
    }

    public void closeBookFile() {
        bookScan.close();
    }

    public void makeBooks() {
        openBookFile();
        this.booksInWorld = readBookFile();
        closeBookFile();
    }

    /**
     * *************************COURSES*******************************************
     */

    private Scanner courseScan;
    public Course[] courseList;

    public void openCourseFile() {
        try {
            courseScan = new Scanner(new File("courses.txt"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not found! check courses.txt");
        }
    }

    public Course[] readCourseFile() {
        courseList = new Course[6];
        courseScan.useDelimiter(";");
        int x = 0;
        while(courseScan.hasNext()){
            String courseName = courseScan.next();
            String stringCourseLiterature = courseScan.next();
            String stringCourseHP = courseScan.nextLine();
            stringCourseHP = stringCourseHP.substring(1, stringCourseHP.length());
            int courseHP = Integer.parseInt(stringCourseHP);
            Book courseLiterature = Main.bookCreator.booksInWorld[1];
            for (int i = 0; i < 6; i++) {
                if (stringCourseLiterature.equals(Main.bookCreator.booksInWorld[i])) {
                    courseLiterature = Main.bookCreator.booksInWorld[i];
                }
            }
            courseList[x] = new Course(courseName, courseLiterature, courseHP);
            x += 1;
        }
        return courseList;
    }

    public void closeCourseFile() {
        courseScan.close();
    }

    public void makeCourses() {
        openCourseFile();
        this.courseList = readCourseFile();
        closeCourseFile();
    }
}