package com.MiscellaneousProjects;

import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pinaki on 12/12/2016.
 */
public class RomanNumeral {

    String inString;
    int myint;
    private  HashMap<Character, Integer> charinthash;
    private  HashMap<Integer, String> intcharhash;


    public HashMap setMyChartoInthash() {
        HashMap<Character, Integer> myhash = new HashMap<>();
        //this.myhash = myhash;
        myhash.put('M',1000);
        myhash.put('X', 10);
        myhash.put('I',1);
        myhash.put('L',50);
        myhash.put('V',5);
        myhash.put('C',100);
        myhash.put('D',500);

        return myhash;

    }

    public HashMap setMyInttoCharhash(){
        HashMap<Integer, String> myhash = new HashMap<>();

        myhash.put(1000,"M");
        myhash.put(900,"CM");
        myhash.put(500,"D");
        myhash.put(100,"C");
        myhash.put(90,"XC");
        myhash.put(50, "L");
        myhash.put(10,"X");
        myhash.put(9,"IX");
        myhash.put(8,"VIII");
        myhash.put(7,"VII");
        myhash.put(6,"VI");
        myhash.put(5,"V");
        myhash.put(4,"IV");
        myhash.put(3,"III");
        myhash.put(2,"II");
        myhash.put(1,"I");

        return myhash;

    }

    public String getInString() {
        return inString;
    }

    public int getMyint() {
        return myint;
    }

    public RomanNumeral(String inString) {
        this.inString = inString;

        if(inString.toUpperCase().matches("[MDCLXVI]*")){

            Pattern p = Pattern.compile("M{4,}|D{4,}|C{4,}|L{4,}|X{4,}|V{4,}|I{4,}");
            Matcher m = p.matcher(inString);

            if(m.find()){
                System.out.println("Found a match: " + m.group());
                System.err.println("Not a valid string");
                throw new NumberFormatException();
            }
            else {
                System.out.println("VALID STRING");
                this.inString = inString;
                this.charinthash=setMyChartoInthash();
            }
        }
        else {
            System.err.println("Not a valid string");
            throw new NumberFormatException();
        }
    }

    public RomanNumeral(int myint) {
        if(myint<1 || myint>3999){
            System.err.println("Number not in range 1-3999");
            throw new NumberFormatException();
        }
        else {
            //System.out.println("INSIDE CONSTRUCTOR: valid number");
            this.myint=myint;
            this.intcharhash=setMyInttoCharhash();
        }
    }

    String toStr () {
        String mystr="";
        int myint = this.getMyint();

        Object[] keyset = intcharhash.keySet().toArray();
        Arrays.sort(keyset);


        for(int i=keyset.length-1; i>=0; i--){
            int key = (int) keyset[i];

            if(myint==key) {
                mystr=mystr+intcharhash.get(key);
                myint=0;
            }
            else if(myint>key) {

                int multiplier = myint/key;
                int rem = myint%key;
                if(multiplier>3){
                    int newkey=key*(multiplier+1);
                    //System.out.println("FOUND MULTIPLIER GREATER THAN 3" + " KEY " + key + " NEWKEY " + newkey);
                    mystr=mystr+intcharhash.get(key)+intcharhash.get(newkey);
                }
                else {
                    for (int r = 0; r < multiplier; r++) {
                        mystr = mystr + intcharhash.get(key);
                    }
                }
                myint=rem;
            }

        }

        //System.out.println("\nMY CONVERTED STRING: " + mystr + " FOR: " + this.getMyint() + "\n");
        return mystr;


    }

    int toInt () {
        String mystr=this.getInString();
        char[] c = mystr.toCharArray();
        int value=0;

        for (int i=0; i<c.length; i++){
            if(i==c.length-1){
                value=value+charinthash.get(c[i]);
            }
            else if( charinthash.get(c[i]) < (int)charinthash.get(c[i+1]) ){
                value=value+charinthash.get(c[i+1])-charinthash.get(c[i]);
                i++;
            }
            else{
                value=value+charinthash.get(c[i]);
            }

        }
        return value;
        //System.out.println("PRINT VALUE: " + value);
    }


}
