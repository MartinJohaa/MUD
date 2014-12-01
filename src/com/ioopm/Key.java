package com.ioopm;
public class Key extends Item {
    private String name = "Key";

    /**
     * creates a Key-object with size 1
     */
    public Key(){
        super(1);
    }
    public String toString(){
        return this.name;
    }

    public String getName(){
        return this.name;
    }
}