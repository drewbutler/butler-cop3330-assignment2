/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Drew Butler
 */
package ex30;

public class MultiplicationTable {
    public static void main(String[] args) {
        for (int i = 1; i <= 12; i++) {
            for (int j = 1; j <= 12; j++) {
                String product = calcProduct(i, j);
                System.out.print(product);
            }
            System.out.println();
        }
    }

    public static String calcProduct(int i, int j) {
        return String.format("%4d", i*j);
    }
}
