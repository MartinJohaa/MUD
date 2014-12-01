package com.ioopm;
abstract class Item {
    private int size;
    public Item(int size){
        this.size = size;
    }
    public int getSize(){
	return size;
    }
    abstract public String toString();
    abstract public String getName();
}