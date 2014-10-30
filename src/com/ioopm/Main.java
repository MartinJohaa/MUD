package com.ioopm;
import java.util.Scanner;

class Main
{
    public static void main(String args[]){
	System.out.println("Enter player name: ");
	Scanner name = new Scanner(System.in);
	String namn1 = name.nextLine();
    Avatar Erik = new Avatar(namn1);
	System.out.printf("Hi, %s! Welcome to P0ll4x!!\n", Erik.getName());
	Erik.addFinishedCourse("Bokvetenskap 101");
	Erik.addFinishedCourse("Datakomm. 301");
	Erik.printList();
    // För att testa om ReadRoomFile lyckas göra sitt.
    ReadRoomFile creator = new ReadRoomFile();
    creator.makeWorld();
    creator.world[0].roomInfo();
    creator.world[1].roomInfo();
    }
}
