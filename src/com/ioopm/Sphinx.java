package com.ioopm;

import java.util.Random;

public class Sphinx extends Creature{

    public Sphinx(Room location){
        super(location);
        location.addCreature(this);
    }

    public boolean graduate(Avatar player){
        if (player.getHP() >= 180){
            System.out.println("Congratulations, you are no longer a student...");
            return true;
        }
        System.out.println("You are not strong enough... \nnomnomnom");
        return false;
    }

    public void communicate(){
        System.out.println("I will eat you alive with mayonnaise if you \ndon't have enough points when you try to graduate!");
    }

}