package com.ioopm;

import java.util.Scanner;

public class Course {
    private String name;
    private Book literature;
    private int HP;

    public Course(String name, Book literature, int HP) {
        this.name = name;
        this.literature = literature;
        this.HP = HP;
    }

    public String toString() {
        return this.name;
    }

    public Book getLiterature() {
        return this.literature;
    }

    /*public Creature getTutor(){
        return this.tutor;
    }*/

    public int getHP() {
        return this.HP;
    }

    public boolean question(Avatar name){
        boolean questionHasBeenAnswered = false;
        boolean hasLiterature = name.checkForLiterature(this.literature.getName());
        if(this.name.equals("Bokvetenskap 101")){
            System.out.println("What is the name of Pippi Longstocking's creator?");
            System.out.println("A: Astrid Lindgren");
            if(!hasLiterature) {
                System.out.println("B: Stieg H. Larsson");
            }
            System.out.println("C: Klaus af Hausserbach");
            while(!questionHasBeenAnswered) {
            System.out.print("Enter your answer (A,B or C): ");
                Scanner userAnswer = new Scanner(System.in);
                String answer = userAnswer.nextLine().toLowerCase();
                if (answer.equals("a") || answer.equals("b") || answer.equals("c")) {
                    if (answer.equals("a")) {
                        return true;
                    } else {
                        System.out.println("Wrong answer! ");
                        return false;
                    }
                }
            }
        }
        if(this.name.equals("Datakommunikation 301")){
            System.out.println("What is ADSL short for?");
            if(!hasLiterature) {
                System.out.println("A: Advanced Data Security Line");
            }
            System.out.println("B: Automatic Dial-up Server Link");
            System.out.println("C: Asymmetric Digital Subscriber Line");
            while(!questionHasBeenAnswered) {
                System.out.print("Enter your answer (A,B or C): ");
                Scanner userAnswer = new Scanner(System.in);
                String answer = userAnswer.nextLine().toLowerCase();
                if (answer.equals("a") || answer.equals("b") || answer.equals("c")) {
                    if (answer.equals("c")) {
                        return true;
                    } else {
                        System.out.println("Wrong answer! ");
                        return false;
                    }
                }
            }
        }
        if(this.name.equals("IOOPM")){
            System.out.println("How do you initialize a string-list in SML?");
            if(!hasLiterature) {
                System.out.println("A: String[] stringList = new String[2]");
            }
            System.out.println("B: val stringList = [\"string1\"]");
            System.out.println("C: char* stringList = {'string1'}");
            while(!questionHasBeenAnswered) {
                System.out.print("Enter your answer (A,B or C): ");
                Scanner userAnswer = new Scanner(System.in);
                String answer = userAnswer.nextLine().toLowerCase();
                if (answer.equals("a") || answer.equals("b") || answer.equals("c")) {
                    if (answer.equals("b")) {
                        return true;
                    } else {
                        System.out.println("Wrong answer! ");
                        return false;
                    }
                }
            }
        }
        return false;
    }
}