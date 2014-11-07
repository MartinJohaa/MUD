package com.ioopm;
import java.util.Random;
import java.util.Scanner;

class Main
{
    public static ReadFile worldCreator;
    public static ReadFile bookCreator;
    public static ReadFile creatureCreator;
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

    public static void placeBooks(Room[] world, Book[] books){
        for (int i = 0; i < 6 ; i++)
            world[randomizer.nextInt(19)].addItem(books[i]);
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
            }
        }else{
            System.out.println("Chosen direction is not valid! Valid directions are: North, East, South, West.");
        }
    }

    public static void unlockDoor(String direction, Avatar name){
        Room originalLocation = name.getCurrentLocation();
        originalLocation.unlockDoor(originalLocation.getDirectionInfoArray(direction));
        String oppositeRoom = originalLocation.getRoomNameInDirection(direction);
        name.setCurrentLocation(oppositeRoom);
        Room oppositeLocation = name.getCurrentLocation();
        oppositeLocation.unlockDoor(oppositeLocation.getDirectionInfoArray(direction));
        name.setCurrentLocation(originalLocation.toString());
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
                    printVariable = true;
                    String loc = name.getCurrentLocation().toString();
                    move(name, input2);
                    if (loc.equals(name.getCurrentLocation().toString())){
                        printVariable = false;
                    }
                    break;
                case "talk":
                    System.out.print("NIY - talk");
                    printVariable = false;
                    break;
                case "pickup":
                    Room location = name.getCurrentLocation();
                    if (input2.equals("book")) {
                        System.out.println("Please enter the name of the book you want to pick up:");
                        Scanner bookName = new Scanner(System.in);
                        input2 = bookName.nextLine().toLowerCase();
                        input2 = input2.substring(1,(input2.length()-1));
                    }
                    int itemIndex = location.findItemIndex(input2);
                        if (itemIndex >= 0) {
                            name.pickupItem(location.getItemAtIndex(itemIndex));
                            printVariable = false;
                            break;
                        }
                        printVariable = false;
                        break;
                case "quit":
                    if (input2.equals("game")) {
                        System.out.println("Safe travels, hope to see you soon again!");
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
                case "unlock":
                    if (input2.equals("door")){
                        System.out.println("Choose direction:");
                        Scanner input3 = new Scanner(System.in);
                        String doorDirection = input3.next();
                        switch (doorDirection) {
                            case "north":
                                /* avatar.checkKey */
                                unlockDoor("north", name);
                                break;
                            case "east":
                                /* avatar.checkKey */
                                unlockDoor("east", name);
                                break;
                            case "south":
                                /* avatar.checkKey */
                                unlockDoor("south", name);
                                break;
                            case "west":
                                /* avatar.checkKey */
                                unlockDoor("west", name);
                                break;
                        }
                    }
                    break;
                default:
                    System.out.println("Valid options are: Go (direction), Talk, Pick up (item)," +
                            " Quit Game, Show Inventory, Unlock Door.");
                    printVariable = false;
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
    worldCreator = new ReadFile();
    worldCreator.makeWorld();
    bookCreator = new ReadFile();
    bookCreator.makeBooks();
    ReadFile creatures = new ReadFile();
    creatures.makeCreatures();
    Erik.setCurrentLocation("FooBar");
    placeKeys(worldCreator.world, Erik);
    placeBooks(worldCreator.world, bookCreator.booksInWorld);
    playGame(Erik);
    }
}
