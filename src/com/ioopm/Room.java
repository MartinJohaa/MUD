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

    // För att skriva ut all info om ett rum
    public void roomInfo() {
        System.out.printf("You have entered %s. \n", this.name);
        System.out.printf("Facing north, you can see a door leading to %s. \n", this.north[0]);
        System.out.printf("If you turn your head to the right facing east " +
                "you see another door leading to %s. \n", this.east[0]);
        System.out.printf("The south door leads to %s, ", this.south[0]);
        System.out.printf("and finally in your western direction you see a door" +
                " that will lead you to %s. \n", this.west[0]);
        System.out.printf("Items found in room: %s", getItems());
        System.out.print("\n");
    }

    public boolean isOpen(String direction) {
        switch (direction) {
            case "North":
                if (this.north[1].equals("True")) {
                    return true;
                } else {
                    return false;
                }
            case "East":
                if (this.east[1].equals("True")) {
                    return true;
                } else {
                    return false;
                }
            case "South":
                if (this.south[1].equals("True")) {
                    return true;
                } else {
                    return false;
                }
            case "West":
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

    public boolean validateConnection(String direction) {
        switch (direction) {
            case "North":
                if (this.north[0].equals("X")) {
                    return false;
                } else {
                    return true;
                }
            case "East":
                if (this.east[0].equals("X")) {
                    return false;
                } else {
                    return true;
                }
            case "South":
                if (this.south[0].equals("X")) {
                    return false;
                } else {
                    return true;
                }
            case "West":
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

    public String getRoomNameInDirection(String direction) {
        switch (direction) {
            case "North":
                return this.north[0];
            case "East":
                return this.east[0];
            case "South":
                return this.south[0];
            case "West":
                return this.west[0];
            default:
                System.out.println("Valid options are: North, East, South, West!");
                return "FEL";
        }
    }

    public void addItem(Items item) {
        this.items.add(item);
    }

    public String getItems() {
        String result = "";
        for (int i = 0; i < items.size(); i++) {
            Items tempItem = items.get(i);
            if (i == (items.size() - 1)) {
                result += tempItem.toString();
            } else {
                result += (tempItem.toString() + ", ");
            }
        }
        return result;
    }
}