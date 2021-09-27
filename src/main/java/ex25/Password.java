/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Drew Butler
 */
package ex25;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Password {
    public static void main(String[] args) {
        System.out.print("Enter password: ");
        Scanner in = new Scanner(System.in);
        String password = in.nextLine();

        int strength = passwordValidator(password);

        String output = printOutput(password, strength);
        System.out.println(output);
    }


    public static int passwordValidator(String password) {
        if (password.length() < 8 && containsDigit(password)) {
            return 0;
        } else if (containsDigit(password) && containsSpecial(password) && containsLetter(password)) {
            return 3;
        } else if (containsDigit(password) || (containsLetter(password) && containsSpecial(password))) {
            return 2;
        } else {
            return 1;
        }
    }

    private boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    public static boolean containsLetter(String password){
        Pattern regex = Pattern.compile(".[a-z]");
        Matcher pword = regex.matcher(password);
        return pword.find();
    }

    public static boolean containsDigit(String password){
        Pattern regex = Pattern.compile(".[0-9]");
        Matcher pword = regex.matcher(password);
        return pword.find();
    }

    public static boolean containsSpecial(String password){
        Pattern regex = Pattern.compile(".[^a-z0-9]");
        Matcher pword = regex.matcher(password);
        return pword.find();
    }

    public static String printOutput(String password, int passwordStrength) {
        return switch (passwordStrength) {
            case 3 -> String.format("The password '%s' is a very strong password.", password);
            case 2 -> String.format("The password '%s' is a strong password.", password);
            case 1 -> String.format("The password '%s' is a weak password.", password);
            default -> String.format("The password '%s' is a very weak password.", password);
        };
    }
}