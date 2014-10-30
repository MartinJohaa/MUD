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
        //rooms = new Scanner(System.in);
        while (rooms.hasNext()){
            String roomName = rooms.next();
        }
    }
}