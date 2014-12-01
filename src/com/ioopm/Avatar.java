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
    private ArrayList<Item> inventory = new ArrayList<>();
    int availableInventorySpace = 10;
    private int HP = 60;

    /**
     * Creates an avatar-object
     * @param name the name of the avatar
     */
    public Avatar(String name){
        this.name = name;
    }

    public String getName(){
	return name;
    }

    public Room getCurrentLocation(){
        return this.currentLocation;
    }

    /**
     * adds an element in the finished course-list
     * @param courseName the name of the course to be added
     */
    public void addFinishedCourse(String courseName){
	    finishedCourses.add(courseName);
        unfinishedCourses.remove(courseName);
    }

    /**
     * adds an element to the unfinished course-list
     * @param course name of the course to be added
     */
    public void addUnfinishedCourse(String course){
	    unfinishedCourses.add(course);
    }

    /**
     * removes a course from the finished course-list
     * @param course the name of the course to be removed
     */
    public void removeFinishedCourse(String course){
        finishedCourses.remove(course);
    }

    /**
     * searches the unfinished course-list for a specific
     * course
     * @param courseName the name of the course to search for
     * @return true if the course is in the list, else false
     */
    public boolean searchUnfinishedCourses(String courseName){
        for (String a:unfinishedCourses){
            if(a.equals(courseName)){
                return true;
            }
        }
        return false;
    }

    /**
     * searches the finished course-list for a specific
     * course
     * @param courseName the name of the course to search for
     * @return true if the course is in the list, else false
     */
    public boolean searchFinishedCourses(String courseName){
        for (String a:finishedCourses){
            if(a.equals(courseName)){
                return true;
            }
        }
        return false;
    }

    public int getHP(){
        return this.HP;
    }

    /**
     * updates the avatar's hp
     * @param points the amount of hps to be added
     */
    public void updateHP(int points){
	HP += points;
    }

    public void setCurrentLocation(String roomname){
    int index = Main.findIndex(roomname, roomList);
    this.currentLocation = Main.worldCreator.world[index];
    }

    /**
     * prints information about the avatar's location
     * to the user
     */
    public void printCurrentLocation(){
    currentLocation.roomInfo();
    }

    public String[] getRoomList(){
        return this.roomList;
    }

    /**
     * if the avatar's inventorySpace !0, adds an item to
     * the avatar's inventory. Also removes the specified item
     * from the current room's itemlist if it is picked up
     * @param itemName the name of the item to be picked up
     */
    public void pickupItem(Item itemName){
        if ((availableInventorySpace - (itemName.getSize())) >= 0){
            currentLocation.removeItem(itemName);
            this.inventory.add(itemName);
            availableInventorySpace -= (itemName.getSize());
            System.out.println("Item picked up successfully!");
        }else{
            System.out.println("Not enough room in inventory!!");
        }
    }

    public ArrayList<Item> getItemList(){
        return this.inventory;
    }

    /**
     * removes an item from the avatar's inventory
     * and adds it to the current room's itemlist
     * @param itemName the item to be dropped
     */
    public void dropItem(Item itemName){
        this.inventory.remove(itemName);
        currentLocation.addItem(itemName);
        this.availableInventorySpace += (itemName.getSize());
    }

    /**
     * adds an item to the avatar's inventory
     * @param itemToAdd the item to be added
     */
    public void addItemToInventory(Item itemToAdd){
        this.inventory.add(itemToAdd);
    }

    /**
     * removes an item from the avatar's inventory
     * @param index index of the item in inventory to
     *              be removed
     */
    public void removeItemFromInventory(int index){
        this.inventory.remove(index);
    }

    public Item getItemAtIndex(int index){
        return (this.inventory.get(index));
    }

    /**
     * prints the avatar's inventory-list to the user
     */
    public void printInventory(){
        System.out.println("INVENTORY");
        System.out.println("*********");
        for (int i = 0; i < inventory.size(); i++){
            System.out.println(inventory.get(i).toString());
        }
        System.out.println("*********");
    }

    /**
     * checks if the avatar's inventory contains a Key, and removes
     * it if it does
     * @return true if a Key is present, else false
     */
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

    /**
     * finds the index of a specified item in
     * the avatar's inventory-list
     * @param itemName name of the item to get the index of
     * @return an int representing the index of the item
     */
    public int findItemIndex(String itemName) {
        int i = 0;
        String itemToBeFound = itemName.toLowerCase();
        for (Item a : this.inventory) {
            String aName = a.getName().toLowerCase();
            if (aName.equals(itemToBeFound)) {
                return i;
            }
            i++;
        }
        System.out.println("Item not found in inventory. ");
        return -1;
    }

    /**
     * checks if a specified Book-object is present in
     * the avatar's inventory-list
     * @param bookName the name of the Book-object to look for
     * @return true if the Book-object is found in inventory,
     * else false
     */
    public boolean checkForLiterature(String bookName){
        for(Item a:this.inventory){
            if(a.getName().equals(bookName)){
                return true;
            }
        }
        return false;
    }
}