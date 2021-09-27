/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Drew Butler
 */
package ex28;

import java.util.Arrays;
import java.util.Scanner;

public class AddingNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] x = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter a number: ");
            x[i] = in.nextInt();
            in.nextLine();
        }
        int total = sumOfX(x);
        System.out.println("The total is " + total + ".");
    }

    public static int sumOfX(int[] x) {
        return Arrays.stream(x).sum();
    }

}
