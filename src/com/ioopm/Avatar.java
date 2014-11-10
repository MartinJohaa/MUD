package com.ioopm;
import java.util.ArrayList;

class Avatar{
    private String[] roomList = {
            "FooBar", "The Tupplurarna's Saxobeat Studio",
            "Hallway 1", "Skrubben", "Room 1211", "Room 1210",
            "Room 1209", "Skyway 1-4", "Hallway 4",
            "Student Services", "Archive", "Janitor's Hideout",
            "Skyway 4-2", "Hallway 2", "Broken Elevator",
            "Update", "Room 2247", "Room 2246", "Room 2245"
    };
    private Room currentLocation;
    private String name;
    private ArrayList<String> unfinishedCourses = new ArrayList<String>();
    private ArrayList<String> finishedCourses = new ArrayList<String>();
    private ArrayList<Items> inventory = new ArrayList<>();
    int availableInventorySpace = 10;
    private int HP = 60;
    public Avatar(String name){
        this.name = name;
    }
    public String getName(){
	return name;
    }
    public Room getCurrentLocation(){
        return this.currentLocation;
    }
    public void addFinishedCourse(String courseName){
	    finishedCourses.add(courseName);
    }
    public void addUnfinishedCourse(String course){
	unfinishedCourses.add(course);
    }
    public int getHP(){
        return this.HP;
    }
    public void updateHP(int points){
	HP += points;
    }
    public void setCurrentLocation(String roomname){
    int index = Main.findIndex(roomname, roomList);
    this.currentLocation = Main.worldCreator.world[index];
    }
    public void printCurrentLocation(){
    currentLocation.roomInfo();
    }

    public String[] getRoomList(){
        return this.roomList;
    }

    public void pickupItem(Items itemName){
        if ((availableInventorySpace - (itemName.getSize())) >= 0){
            currentLocation.removeItem(itemName);
            this.inventory.add(itemName);
            availableInventorySpace -= (itemName.getSize());
            System.out.println("Item picked up successfully!");
        }else{
            System.out.println("Not enough room in inventory!!");
        }
    }

    public void dropItem(Items itemName){
        this.inventory.remove(itemName);
        currentLocation.addItem(itemName);
        this.availableInventorySpace += (itemName.getSize());
    }

    public Items getItemAtIndex(int index){
        return (this.inventory.get(index));
    }

    public void printInventory(){
        System.out.println("INVENTORY");
        System.out.println("*********");
        for (int i = 0; i < inventory.size(); i++){
            System.out.println(inventory.get(i).toString());
        }
        System.out.println("*********");
    }
    public boolean checkForKeyAndRemove(){
        for (int i = 0; i < this.inventory.size(); i++){
            if (this.inventory.get(i).toString().equals("Key")){
                this.inventory.remove(i);
                this.availableInventorySpace += 1;
                return true;
            }
        }
        return false;
    }

    public int findItemIndex(String itemName) {
        int i = 0;
        for (Items a : this.inventory) {
            String aName = a.getName().toLowerCase();
            if (aName.equals(itemName)) {
                return i;
            }
            i++;
        }
        System.out.println("Item not found in inventory. ");
        return -1;
    }
}