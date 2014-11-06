package com.ioopm;
import java.util.Random;
import java.util.Scanner;

class Main
{
    public static ReadRoomFile creator;
    public static Random randomizer = new Random();


    /**
     * method to find index of a specific string in an array
     * @param string name of the room
     * @param array name of array variable
     * @return index of string in array
     */
    public static int findIndex(String string, String[] array){
        for (int i = 0; i <= 18; i++){
            if (array[i].equals(string)){
                return i;
            }
        }
        return -1;
    }


    public static void placeKeys(Room[] world, Avatar name){
        int keysForUnlockedRooms = 4;
        int keysForLockedRooms = 8;
        String[] unlockedRooms =  {
                "FooBar", "Hallway 1", "Skyway 1-4", "Hallway 4",
                "Student Services", "Skyway 4-2", "Hallway 2",
                "Room 2247", "Room 2246"
        };
        String[] lockedRooms =  {
                "The Tupplurarna's Saxobeat Studio",
                "Skrubben", "Room 1211", "Room 1210",
                "Room 1209", "Archive", "Janitor's Hideout",
                "Broken Elevator", "Update","Room 2245"
        };
        for (int i = keysForUnlockedRooms; i > 0; i--){
            Key newkey = new Key();
            String tempRoom = unlockedRooms[randomizer.nextInt(9)];
            int tempIndex = Main.findIndex(tempRoom, name.getRoomList());
            world[tempIndex].addItem(newkey);
        }
        for (int i = keysForLockedRooms; i > 0; i--){
            Key newkey = new Key();
            String tempRoom = lockedRooms[randomizer.nextInt(10)];
            int tempIndex = Main.findIndex(tempRoom, name.getRoomList());
            world[tempIndex].addItem(newkey);
        }
    }

    /**
     *
     * @param name
     */
    public static void move(Avatar name, String direction){
        Room location = name.getCurrentLocation();
        if (direction.equals("north")||direction.equals("east")||direction.equals("south")||direction.equals("west")){
            if (location.validateConnection(direction)) {
                if (location.isOpen(direction)){
                    name.setCurrentLocation(location.getRoomNameInDirection(direction));

                }else{
                    System.out.println("Door is locked,You n33d k3y f0r 0p3n, bb!!");
                }
            }else{
                System.out.println("There is no door in that direction!");
                move(name, direction);
            }
        }else{
            System.out.println("Chosen direction is not valid! Valid directions are: North, East, South, West.");
            move(name, direction);
        }
    }

    public static void playGame(Avatar name){
        boolean gameOn = true;
        boolean printVariable = true;
        while(gameOn) {
            if (printVariable) {
                name.printCurrentLocation();
            }
            System.out.println("Choose your action: ");
            Scanner scannerInput = new Scanner(System.in);
            String input1 = scannerInput.next().toLowerCase();
            String input2 = scannerInput.next().toLowerCase();
            switch(input1){
                case "go":
                    move(name, input2);
                    printVariable = true;
                    break;
                case "talk":
                    System.out.print("NIY - talk");
                    printVariable = false;
                    break;
                case "pickup":

                    name.pickupItem();
                    printVariable = false;
                    break;
                case "quit":
                    if (input2.equals("game")) {
                        gameOn = false;
                        break;
                    }
                    printVariable = true;
                    break;
                case "show":
                    if (input2.equals("inventory")){
                        name.printInventory();
                        printVariable = false;
                        break;
                    }
                default:
                    System.out.println("Valid options are: Go (direction), Talk, Pick up (item)," +
                            " Quit Game, Show Inventory.");
                    printVariable = false;

            /*
            name.printCurrentLocation();
            move(name);
            System.out.println("Continue your adventure? (Yes/No)");
            Scanner answerToTheUltimateQuestion = new Scanner(System.in);
            String answer = answerToTheUltimateQuestion.nextLine();
            if (answer.equals("No")||answer.equals("no")||answer.equals("NO")){
                gameOn = false;*/
            }
        }
    }

    public static void main(String args[]){
    System.out.println("Enter player name: ");
	Scanner name = new Scanner(System.in);
	String namn1 = name.nextLine();
    Avatar Erik = new Avatar(namn1);
	System.out.printf("Hi, %s! Welcome to P0ll4x!!\n", Erik.getName());
	Erik.addFinishedCourse("Bokvetenskap 101");
	Erik.addFinishedCourse("Datakomm. 301");
	//Erik.printList();
    // För att testa om ReadRoomFile lyckas göra sitt.
    creator = new ReadRoomFile();
    creator.makeWorld();
    ReadRoomFile creatures = new ReadRoomFile();
    creatures.makeCreatures();
    Erik.setCurrentLocation("FooBar");
    placeKeys(creator.world, Erik);
    /*creator.world[0].roomInfo();
    creator.world[1].roomInfo();
    Erik.setCurrentLocation("Hallway 4");
    Erik.printCurrentLocation();
    Erik.setCurrentLocation("Room 1357");
    Erik.printCurrentLocation();*/
    playGame(Erik);
    }
}
