package com.ioopm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Main
{
    public static ReadFile worldCreator;
    public static ReadFile bookCreator;
    public static ReadFile creatureCreator;
    public static ReadFile courseCreator;
    public static Random randomizer = new Random();
    public static Avatar playerAvatar;
    public static Creature[] tutors = new Creature[6];
    public static Creature[] students = new Creature[2];

    public static int x = randomizer.nextInt(19);



    /**
     * method to find index of a specific string in an array
     * @param string name of the room
     * @param array name of array variable
     * @return index of string in array
     */
    public static int findIndex(String string, String[] array){
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(string)) {
                return i;
            }
        }
        return -1;
    }

    public static void linkCourses(Course[] courses, Creature[] tutors){
        int i = 0;
        for(Creature a:tutors){
            a.setCourse(courses[i]);
            i++;
        }
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
        for (int i = 0; i < 6 ; i++) {
            world[randomizer.nextInt(19)].addItem(books[i]);
        }
        for (int i = 0; i < 2; i++) {
            int x = 6;
            Main.students[i].setCourseBook(books[x]);
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
            }
        }else{
            System.out.println("Chosen direction is not valid! Valid directions are: North, East, South, West.");
        }
    }

    public static void unlockDoor(String direction, Avatar name){
        String oppositeDirection;
        switch (direction){
            case "north":
                oppositeDirection = "south";
                break;
            case "east":
                oppositeDirection = "west";
                break;
            case "south":
                oppositeDirection = "north";
                break;
            default:
                oppositeDirection = "east";
                break;
        }
        /*Sets originalLocation to the currentLocation.*/
        Room originalLocation = name.getCurrentLocation();
        /*Unlocks the door in the currentLocation in desired direction.*/
        originalLocation.unlockDoor(originalLocation.getDirectionInfoArray(direction));
        /*Sets oppositeRoom to the name of the room on the other side of the unlocked door.*/
        String oppositeRoom = originalLocation.getRoomNameInDirection(direction);
        /*Change the location to the room on the other side of the unlocked door */
        name.setCurrentLocation(oppositeRoom);
        /*Sets oppositeLocation to the new location*/
        Room oppositeLocation = name.getCurrentLocation();
        /*Unlocks the "same" door from the new location*/
        oppositeLocation.unlockDoor(oppositeLocation.getDirectionInfoArray(oppositeDirection));
        /*Change the location back to the originalLocation*/
        name.setCurrentLocation(originalLocation.toString());
    }

    public static void playGame(Avatar name, Sphinx sphinx){
        boolean gameOn = true;
        boolean printVariable = true;
        while(gameOn) {
            if (printVariable) {
                name.printCurrentLocation();
            }
            System.out.println("Choose your action: ");
            Scanner scannerInput = new Scanner(System.in);
            String input1 = scannerInput.next().toLowerCase();
            switch(input1){
                case "go":
                    String input2 = scannerInput.next().toLowerCase();
                    printVariable = true;
                    String loc = name.getCurrentLocation().toString();
                    move(name, input2);
                    if (loc.equals(name.getCurrentLocation().toString())){
                        printVariable = false;
                    }
                    break;
                case "talk":
                    input2 = scannerInput.next().toLowerCase();
                    if(input2.equals("sphinx")){
                        sphinx.communicate();
                    }
                    if(input2.equals("student")){
                        System.out.println("Specify which student (surname lastname): ");
                        Scanner studentName = new Scanner(System.in);
                        String nameInput = studentName.nextLine();
                        Room currentRoom = name.getCurrentLocation();
                        ArrayList<Creature> creaturesInThisRoom = currentRoom.getCreatureList();
                        for (int i = 0; i < creaturesInThisRoom.size(); i++){
                            if (nameInput.equals(creaturesInThisRoom.get(i).toString())){
                                creaturesInThisRoom.get(i).talk();
                            }
                        }
                    }
                    printVariable = false;
                    break;
                case "pick":
                    input2 = scannerInput.next().toLowerCase();
                    String itemInput = scannerInput.next();
                    if (input2.equals("up")){
                        Room location = name.getCurrentLocation();
                        if (itemInput.equals("book")) {
                            System.out.println("Please enter the name of the book you want to pick up:");
                            Scanner bookName = new Scanner(System.in);
                            itemInput = bookName.nextLine().toLowerCase();
                            itemInput = itemInput.substring(1, (itemInput.length() - 1));
                        }
                        int itemIndex = location.findItemIndex(itemInput);
                        if (itemIndex >= 0) {
                            name.pickupItem(location.getItemAtIndex(itemIndex));
                            printVariable = false;
                            break;
                        }
                        printVariable = false;
                        break;
                    }
                case "drop":
                    input2 = scannerInput.next().toLowerCase();
                    Room location = name.getCurrentLocation();
                    if (input2.equals("key")) {
                        if (name.checkForKeyAndRemove()) {
                            location.addItem(new Key());
                            System.out.println("Key dropped successfully!");
                        } else {
                            System.out.println("Item not found in inventory!");
                        }
                    }
                    if (input2.equals("book")) {
                        System.out.println("Please enter the name of the book you want to drop:");
                        Scanner bookName = new Scanner(System.in);
                        itemInput = bookName.nextLine().toLowerCase();
                        itemInput = itemInput.substring(1, (itemInput.length() - 1));
                        int itemIndex = name.findItemIndex(itemInput);
                        if (itemIndex >= 0) {
                            Items tempBook = name.getItemAtIndex(itemIndex);
                            name.dropItem(tempBook);
                            System.out.println("Item dropped successfully!");
                            printVariable = false;
                            break;
                        }
                        printVariable = false;
                        break;
                    }
                    printVariable = false;
                    break;

                case "graduate":
                    if (sphinx.graduate(name)) {
                        gameOn = false;
                        break;
                    }
                    printVariable = false;
                    break;

                case "quit":
                    System.out.println("Safe travels, hope to see you soon again!");
                    gameOn = false;
                    break;
                case "inventory":
                    name.printInventory();
                    printVariable = false;
                    break;

                case "unlock":
                    input2 = scannerInput.next().toLowerCase();
                    if (input2.equals("door")){
                        System.out.println("Choose direction:");
                        Scanner input3 = new Scanner(System.in);
                        String doorDirection = input3.next();
                        switch (doorDirection) {
                            case "north":
                                if (name.checkForKeyAndRemove()) {
                                    unlockDoor("north", name);
                                    System.out.println("[Sound of door being unlocked]");
                                    break;
                                }
                                System.out.println("You have no key in your inventory!");
                                break;
                            case "east":
                                if (name.checkForKeyAndRemove()) {
                                    unlockDoor("east", name);
                                    System.out.println("[Sound of door being unlocked]");
                                    break;
                                }
                                System.out.println("You have no key in your inventory!");
                                break;
                            case "south":
                                if (name.checkForKeyAndRemove()) {
                                    unlockDoor("south", name);
                                    System.out.println("[Sound of door being unlocked]");
                                    break;
                                }
                                System.out.println("You have no key in your inventory!");
                                break;
                            case "west":
                                if (name.checkForKeyAndRemove()) {
                                    unlockDoor("west", name);
                                    System.out.println("[Sound of door being unlocked]");
                                    break;
                                }
                                System.out.println("You have no key in your inventory!");
                                break;
                        }
                        printVariable = false;
                    }
                    break;
                default:
                    System.out.println("Valid options are: Go (Direction), Talk (sphinx), Pick Up (Item)," +
                            " Drop Key/Book, Inventory, Unlock Door, Quit");
                    printVariable = false;
            }
        }
    }

    public static void main(String args[]){
    System.out.println("Enter player name: ");
	Scanner name = new Scanner(System.in);
	String namn1 = name.nextLine();
    playerAvatar = new Avatar(namn1);
	System.out.printf("Hi, %s! Welcome to P0ll4x!!\n", playerAvatar.getName());
    worldCreator = new ReadFile();
    worldCreator.makeWorld();
    bookCreator = new ReadFile();
    bookCreator.makeBooks();
    creatureCreator = new ReadFile();
    creatureCreator.makeCreatures();
    courseCreator = new ReadFile();
    courseCreator.makeCourses();
    playerAvatar.setCurrentLocation("FooBar");
    placeKeys(worldCreator.world, playerAvatar);
    placeBooks(worldCreator.world, bookCreator.booksInWorld);
    Room sphinxLocation = worldCreator.world[x];
    Sphinx sphinx = new Sphinx(sphinxLocation);
    linkCourses(courseCreator.courseList, tutors);
    linkCourses(courseCreator.courseList, students);
    playGame(playerAvatar, sphinx);
    }
}