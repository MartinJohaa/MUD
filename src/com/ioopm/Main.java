package com.ioopm;
import java.util.ArrayList;
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

    public static int[] indexOfSphinxRooms = {1,3,6,10,11,14,15,18};
    public static int x = randomizer.nextInt(8);
    public static int getSphinxRoomIndex(int randNum, int[] roomIndexArray){
        return roomIndexArray[randNum];
    }



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
        int bookIndex = 6;
        for (int i = 0; i < 2; i++) {
            Main.students[i].setCourseBook(books[bookIndex]);
            bookIndex += 1;
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
        boolean enteredNewRoom = true;
        while(gameOn) {
            if (enteredNewRoom) {
                name.printCurrentLocation();
                int teacherIndex = name.getCurrentLocation().ifTeacherPresentGetIndex();
                if (teacherIndex>=0){
                    Creature teacherInRoom = name.getCurrentLocation().getCreature(teacherIndex);
                    teacherInRoom.question(name);
                }
            }
            System.out.println("Choose your action: ");
            Scanner scannerInput = new Scanner(System.in);
            String input1 = scannerInput.next().toLowerCase();
            switch(input1){
                case "enroll":
                    enteredNewRoom = false;
                    String input2 = scannerInput.nextLine().toLowerCase().substring(1);
                    int teacherIndex = name.getCurrentLocation().ifTeacherPresentGetIndex();
                    Creature teacherInRoom = name.getCurrentLocation().getCreature(teacherIndex);
                    if (teacherIndex>=0){
                        if (input2.equals(teacherInRoom.getCourse().toString().toLowerCase())) {
                            Course courseToBeAdded = teacherInRoom.getCourse();
                            if (name.searchUnfinishedCourses(courseToBeAdded.toString())) {
                                System.out.println("You have already enrolled in this course!");
                                break;
                            }
                            name.addUnfinishedCourse(courseToBeAdded.toString());
                            System.out.println("Course added to your unfinished courses!");
                            break;
                        }
                        System.out.println("There is no teacher present that teaches the specified course!");
                        break;
                    }
                    System.out.println("Teacher not found in room!");
                    break;

                case "go":
                    input2 = scannerInput.next().toLowerCase();
                    enteredNewRoom = true;
                    String loc = name.getCurrentLocation().toString();
                    move(name, input2);
                    if (loc.equals(name.getCurrentLocation().toString())){
                        enteredNewRoom = false;
                    }
                    break;
                /*
                case "trade":
                    enteredNewRoom = false;
                    System.out.println("Specify which student you want to trade with (surname lastname): ");
                    Scanner studentInput = new Scanner(System.in);
                    String tradingStudentName = studentInput.nextLine().toLowerCase();
                    ArrayList<Creature> creaturesInRoom = name.getCurrentLocation().getCreatureList();
                    for (Creature a:creaturesInRoom){
                        if (a.toString().equals(tradingStudentName)){
                            System.out.println("Do you want the course literature or the correct answer to \nthe teachers" +
                                    "question?");
                            Scanner trade = new Scanner(System.in);
                            String tradeChoice = trade.nextLine().toLowerCase();
                            if (tradeChoice.equals(a.getCourseB()))
                            a.trade(tradeChoice)
                        }
                    }
                    break;*/

                case "talk":
                    enteredNewRoom = false;
                    input2 = scannerInput.next().toLowerCase();
                    if(input2.equals("sphinx")){
                       ArrayList<Creature> rc = name.getCurrentLocation().getCreatureList();
                       boolean sphinxInRoom = false;
                       for (Creature a:rc){
                            if (a.toString().equals("The Almighty Sphinx of Eternal Life and Crazy Powers")){
                                sphinx.communicate();
                                sphinxInRoom = true;
                            }
                       }
                       if (!sphinxInRoom){
                           System.out.println("There ain't no Sphinx in here!");
                       }
                        break;
                    }
                    if(input2.equals("student")) {
                        System.out.println("Specify which student (surname lastname): ");
                        Scanner studentName = new Scanner(System.in);
                        String nameInput = studentName.nextLine().toLowerCase();
                        Room currentRoom = name.getCurrentLocation();
                        ArrayList<Creature> creaturesInThisRoom = currentRoom.getCreatureList();
                        boolean StudentIsFound = false;
                        for (int i = 0; i < creaturesInThisRoom.size(); i++) {
                            if (nameInput.equals(creaturesInThisRoom.get(i).toString().toLowerCase())) {
                                creaturesInThisRoom.get(i).talk();
                                StudentIsFound = true;
                            }
                        }
                        if (StudentIsFound) {
                            break;
                        }
                        System.out.println("Student not found in this room!");
                        break;
                    }

                case "pick":
                    enteredNewRoom = false;
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
                            break;
                        }
                        break;
                    }

                case "drop":
                    enteredNewRoom = false;
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
                            break;
                        }
                        break;
                    }
                    break;

                case "graduate":
                    if (sphinx.graduate(name)) {
                        gameOn = false;
                        break;
                    }
                    enteredNewRoom = false;
                    break;

                case "quit":
                    System.out.println("Safe travels, hope to see you soon again!");
                    gameOn = false;
                    break;

                case "inventory":
                    name.printInventory();
                    enteredNewRoom = false;
                    break;

                case "hp":
                    int hp = name.getHP();
                    System.out.printf("%d\n",hp);
                    enteredNewRoom = false;
                    break;

                case "unlock":
                    enteredNewRoom = false;
                    input2 = scannerInput.next().toLowerCase();
                    if (input2.equals("door")){
                        System.out.println("Choose direction:");
                        Scanner input3 = new Scanner(System.in);
                        String doorDirection = input3.next();
                        switch (doorDirection) {
                            case "north":
                                if (name.getCurrentLocation().isOpen(doorDirection)) {
                                    System.out.println("That door is already unlocked!");
                                    break;
                                    }
                                if  (name.checkForKeyAndRemove()){
                                    if (name.getCurrentLocation().validateConnection(doorDirection)) {
                                        unlockDoor("north", name);
                                        System.out.println("[Sound of door being unlocked]");
                                        break;
                                    }
                                    System.out.println("There is no door in that direction!");
                                    break;
                                }
                                System.out.println("You have no key in your inventory!");
                                break;
                            case "east":
                                if (name.getCurrentLocation().isOpen(doorDirection)) {
                                    System.out.println("That door is already unlocked!");
                                    break;
                                }
                                if  (name.checkForKeyAndRemove()){
                                    if (name.getCurrentLocation().validateConnection(doorDirection)) {
                                        unlockDoor("east", name);
                                        System.out.println("[Sound of door being unlocked]");
                                        break;
                                    }
                                    System.out.println("There is no door in that direction!");
                                    break;
                                }
                                System.out.println("You have no key in your inventory!");
                                break;
                            case "south":
                                if (name.getCurrentLocation().isOpen(doorDirection)) {
                                    System.out.println("That door is already unlocked!");
                                    break;
                                }
                                if  (name.checkForKeyAndRemove()){
                                    if (name.getCurrentLocation().validateConnection(doorDirection)) {
                                        unlockDoor("south", name);
                                        System.out.println("[Sound of door being unlocked]");
                                        break;
                                    }
                                    System.out.println("There is no door in that direction!");
                                    break;
                                }
                                System.out.println("You have no key in your inventory!");
                                break;
                            case "west":
                                if (name.getCurrentLocation().isOpen(doorDirection)) {
                                    System.out.println("That door is already unlocked!");
                                    break;
                                }
                                if  (name.checkForKeyAndRemove()){
                                    if (name.getCurrentLocation().validateConnection(doorDirection)) {
                                        unlockDoor("west", name);
                                        System.out.println("[Sound of door being unlocked]");
                                        break;
                                    }
                                    System.out.println("There is no door in that direction!");
                                    break;
                                }
                                System.out.println("You have no key in your inventory!");
                                break;
                        }
                    }
                    break;
                case "help":
                    System.out.println("----------------------------------------");
                    System.out.println("This is a GAME DESCRIPTION:");
                    System.out.println("----------------------------------------");
                    System.out.println("You need 180 HP in " +
                            "order to graduate at The Sphinx of Eternal Life And Power.\n" +
                            "In order to reach 180 HP you have to enroll courses given by different teachers encountered in the world \n" +
                            "of Pollax. When you have enrolled a specific course, and enter a room where the course's teacher is present,\n" +
                            "you have a 75% chance of getting an exam-question from him or her. " +
                            "The question has three answering alternatives,\n" +
                            "but if you have the course literature in your inventory one of the wrong alternatives will be removed.\n" +
                            "Good luck on your journey!\n");
                    System.out.println("----------------------------------------");
                    enteredNewRoom = false;
                    break;
                default:
                    System.out.println("Valid options are: Go (Direction), Talk (sphinx, student), Pick Up (Item)," +
                            " Drop Key/Book\n, Inventory, Enroll (course), Unlock Door, Graduate, Help, Quit");
                    enteredNewRoom = false;
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
    Room sphinxLocation = worldCreator.world[getSphinxRoomIndex(x, indexOfSphinxRooms)];
    Sphinx sphinx = new Sphinx(sphinxLocation);
    linkCourses(courseCreator.courseList, tutors);
    linkCourses(courseCreator.courseList, students);
    playGame(playerAvatar, sphinx);
    }
}