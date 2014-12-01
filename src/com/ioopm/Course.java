package com.ioopm;

import java.util.Scanner;

public class Course {
    private String name;
    private Book literature;
    private int HP;

    /**
     * Creates a Course-object with a name, course literature and
     * a specified amount of "graduation-points"
     * @param name name of the course
     * @param literature name course literature
     * @param HP int representing amount of "graduation-points"
     */
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

    public int getHP() {
        return this.HP;
    }

    /**
     * Gives the user a question about something related to
     * the course the related teacher holds
     * @param name the avatar used to search if it holds the related course literature
     * @return true if the user inputs the correct answer to the question,
     * else false
     */
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
            System.out.println("What object is depicted in the Java logotype?");
            if(!hasLiterature) {
                System.out.println("A: A penguin");
            }
            System.out.println("B: A coffee-mug");
            System.out.println("C: An apple");
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
        if(this.name.equals("PKD")){
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
        if(this.name.equals("Dinosaurielära")){
            System.out.println("What animal was used to recreate the sound of a T.Rex" +
                    "in \nJurassic Park\"");
            System.out.println("A: A grizzly-bear");
            if(!hasLiterature) {
                System.out.println("B: A black panther");
            }
            System.out.println("C: A koala-bear");
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
        if(this.name.equals("AsciiArt")){
            System.out.println("What is the ascii-value of a lower-case A?");
            System.out.println("A: 97");
            if(!hasLiterature) {
                System.out.println("B: 87");
            }
            System.out.println("C: 11");
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
        if(this.name.equals("Cherish Your Chocolate")){
            System.out.println("Which country in the world has the largest export of cacao-beans?");
            System.out.println("A: Cote d'Ivoire");
            System.out.println("B: Indonesia");
            if(!hasLiterature) {
                System.out.println("C: Ghana");
            }
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
        if(this.name.equals("Gjutjärnssmide")){
            System.out.println("What is the melting of iron?");
            System.out.println("A: 597°C");
            System.out.println("B: 1539°C");
            if(!hasLiterature) {
                System.out.println("C: 2314°C");
            }
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
        if(this.name.equals("Presentera med overhead")){
            System.out.println("What do you need in order to use an overhead-projector?");
            System.out.println("A: Paper");
            System.out.println("B: Electricity");
            if(!hasLiterature) {
                System.out.println("C: Water ");
            }
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
        if(this.name.equals("Camping")){
            System.out.println("Which campsite is named Sweden's biggest?");
            System.out.println("A: Böda Sand");
            System.out.println("B: Pite Havsbad");
            if(!hasLiterature) {
                System.out.println("C: Sunnersta Camping");
            }
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
        if(this.name.equals("MOOP")){
            System.out.println("How many cores are there in NASA's supercomputer \"Pleiades\"?");
            if(!hasLiterature) {
                System.out.println("A: 15.000");
            }
            System.out.println("B: 150.000");
            System.out.println("C: 184.800");
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
        if(this.name.equals("Ostkunskap")){
            System.out.println("Which country in the world eats most cheese per capita each year?");
            System.out.println("A: England");
            if(!hasLiterature) {
                System.out.println("B: Italy");
            }
            System.out.println("C: France");
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
        if(this.name.equals("Vallarteknik")){
            System.out.println("Which of the following are not a type of skiwax?");
            System.out.println("A: kickwax");
            System.out.println("B: slippywax");
            if(!hasLiterature) {
                System.out.println("C: stickywax");
            }
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
        if(this.name.equals("Musikteori")){
            System.out.println("What is the easiest way to learn the guitar?");
            System.out.println("A: Rocksmith");
            if(!hasLiterature) {
                System.out.println("B: Rockband");
            }
            System.out.println("C: Guitar Hero");
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
        return false;
    }
}