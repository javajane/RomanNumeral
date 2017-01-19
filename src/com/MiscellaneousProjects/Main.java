package com.MiscellaneousProjects;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        boolean quit=false;
        Scanner scanner=new Scanner(System.in);

        System.out.println("This program will convert a Arabic numeral --> Roman Numeral");
        System.out.println("This program will convert a Roman numeral --> Arabic Numeral\n");

        while(!quit){

            System.out.println("Please enter Arabic/ROman numeral");
            System.out.println("Or enter q to quit");

            if(scanner.hasNextInt()){
                int input=scanner.nextInt();
                //System.out.println("INPUT is INTEGER converting to ROMAN");
                RomanNumeral roman = new RomanNumeral(input);
                System.out.println("ARABIC:\t" + input + "\tROMAN NUMBERAL: " + roman.toStr() + "\n");

                //roman.toStr();
            }
            else{
                String input=scanner.next();
                //System.out.println("INPUT STRING: " + input);
                if(input.toUpperCase().charAt(0)=='Q'){
                    quit=true;
                }
                else {
                    //System.out.println("INPUT IS ROMAN, converting to INTEGER");
                    RomanNumeral roman = new RomanNumeral(input);
                    System.out.println("ROMAN\t" + input + "\tARABIC NUMBERAL: " + roman.toInt() + "\n");
                   // roman.toInt();
                }
            }




        }

    }
}
