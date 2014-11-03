package com.ioopm;
import java.util.Scanner;

class Main
{
    public static ReadRoomFile creator;

    /**
     * method to find index of a specific string in an array
     * @param string name of the room
     * @param array name of array variable
     * @return index of string in array
     */
    public static int findIndex(String string, String[] array){
        for (int i = 0; i <= 2; i++){
            if (array[i].equals(string)){
                return i;
            }
        }
        return -1;
    }


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
    creator = new ReadRoomFile();
    creator.makeWorld();
    creator.world[0].roomInfo();
    creator.world[1].roomInfo();
    Erik.setCurrentLocation("Hallway 4");
    Erik.printCurrentLocation();
    Erik.setCurrentLocation("Room 1357");
    Erik.printCurrentLocation();
    }
}
