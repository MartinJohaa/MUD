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

    public boolean question(){
        boolean questionHasBeenAnswered = false;
        if(this.name.equals("Bokvetenskap 101")){
            System.out.println("What is the name of Pippi Longstocking's creator?");
            System.out.println("A: Astrid Lindgren");
            System.out.println("B: Stieg H. Larsson");
            System.out.println("C: Klaus af Hausserbach");
            while(!questionHasBeenAnswered) {
            System.out.print("Enter your answer (A,B or C): ");
                Scanner userAnswer = new Scanner(System.in);
                String answer = userAnswer.nextLine().toLowerCase();
                if (answer.equals("a") || answer.equals("b") || answer.equals("c")) {
                    if (answer.equals("a")) {
                        return true;
                    } else {
                        System.out.print("Wrong answer! ");
                        return false;
                    }
                }
            }
        }
        if(this.name.equals("Datakommunikation 301")){
            System.out.println("What is ADSL short for?");
            System.out.println("A: Advanced Data Security Line");
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
                        System.out.print("Wrong answer! ");
                        return false;
                    }
                }
            }
        }
        return false;
    }
}