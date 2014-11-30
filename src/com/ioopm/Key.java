package com.ioopm;
public class Key extends Item {
    private String name = "Key";
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