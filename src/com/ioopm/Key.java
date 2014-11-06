package com.ioopm;
public class Key extends Items{
    private String name = "Key";
    public Key(){
        setSize(1);
    }
    public String toString(){
        return this.name;
    }

    public String getName(){
        return this.name;
    }
}
