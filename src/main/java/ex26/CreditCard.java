/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Drew Butler
 */
package ex26;

import static java.lang.Math.*;
import java.util.Scanner;

public class CreditCard {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("what is your balance? ");
        double b = in.nextDouble();
        in.nextLine();

        System.out.print("What is the APR on your card (as a percent)? ");
        double apr = in.nextDouble();
        in.nextLine();

        System.out.print("What is the monthly payment you make? ");
        double p = in.nextDouble();
        in.nextLine();

        int months = formula(b, apr, p);

        System.out.println("It will take you " + months + " months to pay off this card.");
    }

    public static int formula(double b, double apr, double p) {
        double i = apr/365.0/100.0;
        return (int) ceil((-1.0/30.0) * Math.log(1.0 + (b/p * (1.0 - Math.pow(1.0 + i,30.0)))) / Math.log(1.0 + i));
    }

}
