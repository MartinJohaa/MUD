package com.ioopm;

abstract class Creature {
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

    public void setCourse(Course c){
    }

    public void setCourseBook(Book b){
    }
    public Book getCourseBook(){
        return(new Book("Erik","sa",1690,5));
    }

    public void talk(){
    }

    abstract public Course getCourse();

    public int whichKindOfCreature(){
        return -1;
    }

    abstract void question(Avatar name);

    abstract Book trade(Book tradeOffer);
}