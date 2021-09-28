/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Drew Butler
 */
package ex34;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeListRemoval {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<String> employees = new ArrayList<>();

        employees.add("John Smith");
        employees.add("Jackie Jackson");
        employees.add("Chris Jones");
        employees.add("Amanda Cullen");
        employees.add("Jeremy Goodwin");

        String output = employeesList(employees);
        System.out.println(output);
        System.out.print("Enter an employee name to remove: ");
        String remove = in.nextLine();

        employees.removeIf(n -> (n.equals(remove)));
        output = employeesList(employees);
        System.out.println(output);
    }

    public static String employeesList(ArrayList<String> employees) {
        int count = employees.size();
        StringBuilder result = new StringBuilder("There are " + count + " employees:\n");

        for (String name : employees) result.append(name).append("\n");
        return result.toString();
    }
}
