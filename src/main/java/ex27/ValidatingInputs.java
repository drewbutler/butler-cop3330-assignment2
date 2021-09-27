package ex27;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatingInputs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the first name: ");
        String first = in.nextLine();
        System.out.print("Enter the last name: ");
        String last = in.nextLine();
        System.out.print("Enter the ZIP code: ");
        String zipcode = in.nextLine();
        System.out.print("Enter the employee ID: ");
        String employeeID = in.nextLine();

        String errors = validateInput(first, last, zipcode, employeeID);
        System.out.println(errors);
    }

    public static String validateInput(String first, String last, String zipcode, String employeeID) {
        String errors = "";

        if(first.length() == 0) {
            errors = errors + "The first name must be filled in.\n";
        }
        if(last.length() == 0) {
            errors = errors + "The last name must be filled in.\n";
        }
        if(first.length() <= 2) {
            errors = errors + "The first name must be at least 2 characters long.\n";
        }
        if(last.length() <= 2) {
            errors = errors + "The last name must be at least 2 characters long. \n";
        }
        if (!formatID(employeeID)) {
            errors = errors + "The employee ID must be in the format of AA-1234.\n";
        }
        if(!zipFormat(zipcode)) {
            errors = errors + "The zipcode must be a 5 digit number.\n";
        }
        if(errors.length() == 0) errors = "There are no errors." ;
        return errors;

    }

    public static boolean formatID(String input) {
        Pattern pattern = Pattern.compile("^[a-zA-Z]{2}+-[0-9]{4}+$" ,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean zipFormat(String input) {
        Pattern pattern = Pattern.compile("^[0-9]{5}+$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }


}
