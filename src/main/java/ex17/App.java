/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Mauricio Rios
 */
package ex17;

import java.util.Scanner;

public class App {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();
        int gender = myApp.getGender();
        int alcohol = myApp.getAlcohol();
        int weight = myApp.getWeight();
        double ratio = myApp.getRatio(gender);
        int time = myApp.getTime();
        double BAC = myApp.getBAC(alcohol, weight, ratio, time);
        String legality = myApp.getLegality(BAC);
        String outputString = myApp.generateOutputString(BAC, legality);
        myApp.printOutput(outputString);
    }

    public int getWeight() {
        int number = 0;
        boolean isNumber;
        do {
            System.out.print("What is your weight, in pounds? ");
            if (in.hasNextInt()) {
                number = in.nextInt();
                isNumber = true;
            } else {
                System.out.println("ERROR: Enter only numbers");
                isNumber = false;
                in.next();
            }
        } while(!(isNumber));
        return number;
    }

    public int getGender() {
        int number = 0;
        boolean isNumber;
        do {
            System.out.print("Enter a 1 if you are male or a 2 if you are female: ");
            if (in.hasNextInt()) {
                number = in.nextInt();
                isNumber = true;
            } else {
                System.out.println("ERROR: Enter only numbers");
                isNumber = false;
                in.next();
            }
        } while(!(isNumber));
        return number;
    }

    public double getRatio(int gender) {
        if(gender == 1)
        {
            return 0.73;
        }
        else
            return 0.66;
    }

    public int getAlcohol() {
        int number = 0;
        boolean isNumber;
        do {
            System.out.print("How many ounces of alcohol did you have? ");
            if (in.hasNextInt()) {
                number = in.nextInt();
                isNumber = true;
            } else {
                System.out.println("ERROR: Enter only numbers");
                isNumber = false;
                in.next();
            }
        } while(!(isNumber));
        return number;

    }

    public int getTime(){
        int number = 0;
        boolean isNumber;
        do {
            System.out.print("How many hours has it been since your last drink? ");
            if (in.hasNextInt()) {
                number = in.nextInt();
                isNumber = true;
            } else {
                System.out.println("ERROR: Enter only numbers");
                isNumber = false;
                in.next();
            }
        } while(!(isNumber));
        return number;
    }

    public double getBAC(int alcohol, int weight, double ratio, int time) {
        double BAC =  (alcohol * 5.14 / weight * ratio) - .015 * time;
        BAC = Math.round(BAC*1000000d)/1000000d;
        return BAC;
    }

    public String getLegality(double BAC) {
        if(BAC < 0.08)
            return "It is legal for you to drive.";
        else
            return "It is not legal for you to drive.";
    }

    public String generateOutputString(double BAC, String legality) {
        return "Your BAC is "+BAC+"\n"+legality;
    }

    public void printOutput(String outputString) {
        System.out.print(outputString);
    }
}