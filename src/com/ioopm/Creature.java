package com.ioopm;

public abstract class Creature {
    private String name;
    private Room location;

    public Creature(Room location){
        this.name = "The Almighty Sphinx of Eternal Life and Crazy Powers";
        this.location = location;
    }

    public Creature(String name, String roomName){
        this.name = name;
        Room[] rooms = Main.worldCreator.world;
        String[] stringArrayOfRooms = Main.playerAvatar.getRoomList();
        int roomIndex = Main.findIndex(roomName, stringArrayOfRooms);
        this.location = rooms[roomIndex];
        this.location.addCreature(this);

    }

    /**
     * changes the location of the Creature-object to another Room
     * @param roomName the Room the creature will be moved to
     */
    public void changeLocation(Room roomName){
        /*remove from current room*/
        this.location.removeCreature(this);
        /*Change to new location*/
        this.location = roomName;
        /*Adds creature in the new room*/
        location.addCreature(this);
    }

    public String toString(){
        return this.name;
    }

    /**
     * method not used here, specialized in sub-classes
     * @param c n/a
     */
    public void setCourse(Course c){
    }

    /**
     * method not used here, specialized in sub-classes
     * @param b n/a
     */
    public void setCourseBook(Book b){
    }

    /**
     * method not used here, specialized in sub-classes
     * @return n/a
     */
    public Book getCourseBook(){
        return(new Book("Erik","sa",1690,5));
    }

    /**
     * method not used here, specialized in sub-classes
     */
    public void talk(){
    }

    /**
     * method not used here, specialized in sub-classes
     * @return none
     */
    abstract public Course getCourse();

    /**
     * method not used here, specialized in sub-classes
     * @return n/a
     */
    public int whichKindOfCreature(){
        return -1;
    }

    /**
     * method not used here, specialized in sub-classes
     * @param name n/a
     */
    abstract void question(Avatar name);

    /**
     * method not used here, specialized in sub-classes
     * @param tradeOffer n/a
     * @return n/a
     */
    abstract Book trade(Book tradeOffer);
}