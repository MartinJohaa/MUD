package com.ioopm;
import java.lang.String;
import java.util.ArrayList;

public class Room {
    /**
     * creating variables for the different elements of a room
     */
    private String name;
    private String[] north = new String[2];
    private String[] east = new String[2];
    private String[] south = new String[2];
    private String[] west = new String[2];
    private ArrayList<Items> items = new ArrayList<Items>();
    private ArrayList<Creature> creatures = new ArrayList<Creature>();

    /**
     * The constructor which creates a room-object
     *
     * @param name            the name of the room
     * @param northConnection the name of the room to the north, if there is one
     * @param eastConnection  -"- east -"-
     * @param southConnection -"- south -"-
     * @param westConnection  -"- west -"-
     * @param northLock       information about whether the north door is locked or not
     * @param eastLock        -"- east -"-
     * @param southLock       -"- south -"-
     * @param westLock        -"- west -"-
     */
    public Room(String name, String northConnection, String eastConnection, String southConnection, String westConnection
            , String northLock, String eastLock, String southLock, String westLock) {
        this.name = name;
        north[0] = northConnection;
        east[0] = eastConnection;
        south[0] = southConnection;
        west[0] = westConnection;
        north[1] = northLock;
        east[1] = eastLock;
        south[1] = southLock;
        west[1] = westLock;
    }

    /**
     *  Method to print out information about the room
     *
     */
    public void roomInfo() {
        System.out.printf("You have entered %s. \n", this.name);
        System.out.printf("Facing north, you can see a door leading to %s. \n", this.north[0]);
        System.out.printf("If you turn your head to the right facing east " +
                "you see another door leading to %s. \n", this.east[0]);
        System.out.printf("The south door leads to %s, ", this.south[0]);
        System.out.printf("and finally in your western direction\nyou see a door" +
                " that will lead you to %s. \n", this.west[0]);
        System.out.println("----------------------------------------");
        System.out.printf("Items found in room: %s\n", printItems());
        System.out.printf("Creatures in room: %s\n", printCreatures());
        System.out.println("----------------------------------------");
    }

    /**
     *  Method used to check the status of the lock in the given
     *  direction
     *
     * @param direction the door's direction
     * @return true if the door is unlocked, else false
     */
    public boolean isOpen(String direction) {
        switch (direction) {
            case "north":
                if (this.north[1].equals("True")) {
                    return true;
                } else {
                    return false;
                }
            case "east":
                if (this.east[1].equals("True")) {
                    return true;
                } else {
                    return false;
                }
            case "south":
                if (this.south[1].equals("True")) {
                    return true;
                } else {
                    return false;
                }
            case "west":
                if (this.west[1].equals("True")) {
                    return true;
                } else {
                    return false;
                }
            default:
                System.out.println("Valid options are: North, East, South, West!");
                return false;
        }
    }

    /**
     *  Method to validate if there is a door in the
     *  given direction.
     *
     * @param direction direction to be validated
     * @return true if a door is present, else false
     */
    public boolean validateConnection(String direction) {
        switch (direction) {
            case "north":
                if (this.north[0].equals("X")) {
                    return false;
                } else {
                    return true;
                }
            case "east":
                if (this.east[0].equals("X")) {
                    return false;
                } else {
                    return true;
                }
            case "south":
                if (this.south[0].equals("X")) {
                    return false;
                } else {
                    return true;
                }
            case "west":
                if (this.west[0].equals("X")) {
                    return false;
                } else {
                    return true;
                }
            default:
                System.out.println("Valid options are: North, East, South, West!");
                return false;
        }
    }

    /**
     * Method to get hold of the name of the room in the
     * given direction.
     *
     * @param direction direction of the room which name is wanted
     * @return the string representing the desired room's name
     */
    public String getRoomNameInDirection(String direction) {
        switch (direction.toLowerCase()) {
            case "north":
                return this.north[0];
            case "east":
                return this.east[0];
            case "south":
                return this.south[0];
            case "west":
                return this.west[0];
            default:
                System.out.println("Valid options are: North, East, South, West!");
                return "FEL";
        }
    }

    /**
     * Method to deliver info about the given direction's
     * connecting door and the status of its lock
     * @param direction the direction to be investigated
     * @return a string array containing the connecting room's
     *         name and the status of the door's lock.
     */
    public String[] getDirectionInfoArray(String direction) {
        switch (direction) {
            case "north":
                return this.north;
            case "east":
                return this.east;
            case "south":
                return this.south;
            case "west":
                return this.west;
            default:
                String[] x = {"Hej"};
                return x;
        }
    }

    /**
     * Method to add an item to the room's itemlist
     * @param item the item to be added
     */
    public void addItem(Items item) {
        this.items.add(item);
    }

    /**
     * Method to remove an item from the room's
     * itemlist
     * @param item the item to be removed
     */
    public void removeItem(Items item) {
        this.items.remove(item);
    }

    /**
     * Method to find the index of a specific item in the room's
     * itemlist.
     * @param itemName the string-representation of the item of
     *                 which the index is wanted
     * @return the int representing the items index
     *         in the room's itemlist
     */
    public int findItemIndex(String itemName) {
        int i = 0;
        for (Items a : this.items) {
            String aName = a.getName().toLowerCase();
            if (aName.equals(itemName)) {
                return i;
            }
            i++;
        }
        System.out.println("Item not found in room. ");
        return -1;
    }

    public Items getItemAtIndex(int i) {
        return this.items.get(i);
    }

    public String printItems() {
        String result = "";
        for (int i = 0; i < this.items.size(); i++) {
            Items tempItem = this.items.get(i);
            if (i == (this.items.size() - 1)) {
                result += tempItem.toString();
            } else {
                result += (tempItem.toString() + ", ");
            }
        }
        return result;
    }

    public void addCreature(Creature creature) {
        this.creatures.add(creature);
    }

    public void removeCreature(Creature creature) {
        creatures.remove(creature);
    }

    public String printCreatures(){
        String result = "";
        for (int i = 0; i < this.creatures.size(); i++) {
            Creature tempItem = this.creatures.get(i);
            if (i == (this.creatures.size() - 1)) {
                result += (tempItem.toString() + ("(" + tempItem.getCourse().toString() + ")"));
            } else {
                result += (tempItem.toString() + ("(" + tempItem.getCourse().toString() + ")") + ", ");
            }
        }
        return result;
    }

    public ArrayList getCreatureList(){
        return this.creatures;
    }

    public String toString() {
        return this.name;
    }

    public void unlockDoor(String[] direction) {
        direction[1] = "True";
    }

    public int ifTeacherPresentGetIndex(){
        int i = 0;
        for (Creature a:this.creatures){
            Integer x = a.whichKindOfCreature();
            if(x.equals(2)){
                return i;
            }
            i++;
        }
        return -1;
    }

    public Creature getCreature(int i){
        return this.creatures.get(i);
    }
}