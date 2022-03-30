package com.Rough;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class RandomString {
    public static void main(String[] args) {

        //System.out.println(Generate_Random_Email());

        String Unique_Email = Generate_Random_Email() + "@Gmail.com";
        System.out.println(Unique_Email);

        String Unique_Password = Generate_Random_Password();
        System.out.println(Unique_Password);
        System.out.println(Unique_Password);
    }
    // for email ID
    public static String Generate_Random_Email() {

        String saltChar = "abcdefABCDEF123";
        StringBuilder randomString = new StringBuilder();
        Random rnd = new Random();

        while (randomString.length() < 10) {
            // Here 10 is the index value, not number
            int index = (int) (rnd.nextFloat() * saltChar.length()); //formula
            randomString.append(saltChar.charAt(index));
        }
        String newString = randomString.toString();
        return newString;
    }
    // for Password
    public static String Generate_Random_Password() {

        String saltChar = "abcABC&$*123";
        StringBuilder randomString = new StringBuilder();
        Random rnd = new Random();

        while (randomString.length() < 7) {
            // Here 7 is the index value, not number
            int index = (int) (rnd.nextFloat() * saltChar.length()); //formula
            randomString.append(saltChar.charAt(index));
        }
        String newString = randomString.toString();
        return newString;
    }

}
