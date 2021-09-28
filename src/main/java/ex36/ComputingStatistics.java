/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Drew Butler
 */
package ex36;

import java.util.ArrayList;
import java.util.Scanner;

public class ComputingStatistics {
    public static void main(String[] args) {
        var times = prompt();
        String pTimes = times(times);
        System.out.println(pTimes);
        String pAvg = average(times);
        String pMin = min(times);
        String pMax = max(times);
        String pStd = std(times);

        String output = String.format("%s\n%s\n%s\n%s", pAvg, pMin, pMax, pStd);
        System.out.println(output);
    }

    public static String average(ArrayList<Integer> times) {
        double avg;
        if (times.size() > 0){
            avg = times.stream().mapToDouble(d -> d).average().orElse(0.0);
        }else {avg = 0.0;}
        return "The average is " + avg;
    }

    public static String min(ArrayList<Integer> times) {
        double min;
        if (times.size() > 0){
            min = times.stream().mapToDouble(d -> d).min().orElse(0.0);
        }else {min = 0.0;}
        return "The minimum is " + (int) min;
    }

    public static String max(ArrayList<Integer> times) {
        double max;
        if (times.size() > 0){
            max = times.stream().mapToDouble(d -> d).max().orElse(0.0);
        }else {max = 0.0;}
        return "The maximum is " + (int) max;
    }

    public static String std(ArrayList<Integer> times) {
        double std;
        if (times.size() > 0){
            double sum = 0.0;
            double stdTmp = 0.0;
            int len = times.size();

            for(double num : times) {
                sum += num;
            }

            double mean = sum/len;

            for(double num: times) {
                stdTmp += Math.pow(num - mean, 2);
            }

            std = Math.sqrt(stdTmp/len);
        }else {std = 0.0;}
        return "The standard deviation is " + String.format("%.2f", std);
    }

    private static String times(ArrayList<Integer> times) {
        StringBuilder results = new StringBuilder("Numbers: ");
        for (Integer time : times) results.append(time).append(", ");
        results.deleteCharAt(results.length() -1);
        results.deleteCharAt(results.length() -1);
        return results.toString();
    }

    public static ArrayList<Integer> prompt(){
        Scanner in = new Scanner(System.in);
        var results = new ArrayList<Integer>();
        String input;
        boolean fail;
        do{
            System.out.print("Enter a number: ");
            input = in.nextLine();
            try {
                int isInt = Integer.parseInt(input);
                if(isInt > 0) {
                    fail = true;
                    results.add(isInt);

                } else {
                    System.out.println("Invalid. Must be greater than 0.");
                    fail = true;
                }
            }
            catch (NumberFormatException e) {
                if(input.equalsIgnoreCase("done")){
                    fail = false;
                } else {
                    System.out.println("Invalid. Must enter a number or done.");
                    fail = true;
                }
            }
        }while(fail);
        return results;
    }
}
