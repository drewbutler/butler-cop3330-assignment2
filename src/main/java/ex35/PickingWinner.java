/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Drew Butler
 */
package ex35;

import java.util.ArrayList;
import java.util.Scanner;

public class PickingWinner {
    public static void main(String[] args) {
        ArrayList<String> contestants = inputContestant();
        int winner = winningContestant(contestants.size());
        String output = String.format("The winner is... %s.", contestants.get(winner));
        System.out.println(output);
    }

    public static int winningContestant(int size) {
        return (int) ((Math.random() * (size)) + 1) - 1;
    }

    private static ArrayList<String> inputContestant() {
        Scanner in = new Scanner(System.in);
        var input = new ArrayList<String>();

        String name;
        do {
            System.out.print("Enter a name: ");
            name = in.nextLine();
            if(!name.equals("")) {
                input.add(name);
            }
        } while (!name.equals(""));
        return input;
    }

}
