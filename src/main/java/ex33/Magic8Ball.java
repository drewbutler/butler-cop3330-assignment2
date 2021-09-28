/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Drew Butler
 */
package ex33;

import java.util.Scanner;

public class Magic8Ball {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("What's your question?\n");
        in.nextLine();

        int random = random();
        String answer = response(random);
        System.out.println(answer);
    }

    public static String response(int random) {
        return switch (random) {
            case 1 -> "Yes";
            case 2 -> "No";
            case 3 -> "Maybe";
            case 4 -> "Ask again later";
            default -> null;
        };
    }

    public static  int random() {
        return (int) (Math.random() * (5-1)) + 1;
    }
}
