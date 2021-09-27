/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Drew Butler
 */
package ex24;

import java.util.Arrays;
import java.util.Scanner;

public class Anagrams {
    public static void main(String[] args) {

        System.out.println("Enter two strings and I'll tell you if they are anagrams:");

        String sOne = prompt("first");
        String sTwo = prompt("second");

        String sOneAlpha = alphabetize(sOne);
        String sTwoAlpha = alphabetize(sTwo);

        boolean isSameLength = isSameLength(sOne, sTwo);
        boolean isAnagram = isAnagram(sOneAlpha, sTwoAlpha);

        String output = generateOutput(isSameLength, isAnagram, sOne, sTwo);

        System.out.println(output);
    }

    private static String prompt(String prompt){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the " + prompt + " string: ");
        return input.nextLine();
    }

    public static boolean isSameLength(String sOne, String sTwo){
        return sOne.length() == sTwo.length();
    }

    public static String alphabetize(String str){
        char[] array = str.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }

    public static boolean isAnagram(String sOne, String sTwo){
        return sOne.equals(sTwo);
    }

    public static String generateOutput(boolean isSameLength, boolean isAnagram, String sOne, String sTwo){
        if (isSameLength && isAnagram)
            return "\"" + sOne + "\" and \"" + sTwo + "\" are anagrams.";
        else return "\"" + sOne + "\" and \"" + sTwo + "\" are not anagrams.";
    }
}
