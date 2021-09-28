/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Drew Butler
 */
package ex32;

import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        GuessTheNumber myNumberGame = new GuessTheNumber();

        System.out.println("Let's play Guess the Number!\n");
        myNumberGame.playGame();

    }

    private void playGame() {
        String playAgain = "y";
        while (playAgain.equalsIgnoreCase("y")) {
            int numGuesses = guessTheNumber();
            System.out.printf("You got it in %d guesses!\n", numGuesses);
            System.out.print("Do you wish to play again (Y/N)? ");
            playAgain = in.nextLine();
        }
    }

    private int guessTheNumber() {
        int numGuesses = 0;
        int difficulty = levelDifficulty("Enter the difficulty level (1, 2, or 3): ");
        System.out.print("I have my number. What's your guess? ");
        int correctNum = solution(difficulty);
        boolean youWon = false;
        while (!youWon) {
            String yourGuess = numGuess();
            numGuesses = numGuesses + 1;
            boolean yourGuessValid = guessValidation(yourGuess);
            if (yourGuessValid) {
                int yourGuessInt = Integer.parseInt(yourGuess);
                if (yourGuessInt < correctNum) {
                    System.out.print("Too low. Guess again: ");
                } else if (yourGuessInt > correctNum) {
                    System.out.print("Too high. Guess again: ");
                } else {
                    youWon = true;
                }
            } else {
                System.out.print("The input enter is not valid, please enter an integer. \nGuess again: ");
            }

        }
        return numGuesses;
    }

    protected boolean guessValidation(String yourGuess) {
        boolean isInputInt;
        try {
            int input = Integer.parseInt(yourGuess);
            isInputInt = true;
        } catch (NumberFormatException e) {
            isInputInt = false;
        }
        return isInputInt;
    }

    private String numGuess() {
        String yourGuess = in.nextLine();
        return yourGuess;
    }

    protected int solution(int difficultyLevel) {
        int rangeOfGame = 10^difficultyLevel;
        Random randNum = new Random();
        int answer = 1 + randNum.nextInt(rangeOfGame);
        return answer;
    }

    private int levelDifficulty(String str) {
        boolean isInputInt = false;
        int input = 0;
        while (!isInputInt) {
            System.out.print(str);
            String inputStr = in.nextLine();
            try {
                input = Integer.parseInt(inputStr);
                isInputInt = true;
            } catch (NumberFormatException e) {
                isInputInt = false;
                System.out.println("The input enter is not valid, please enter an integer.");
            }
            if (input < 0 || input > 4) {
                isInputInt = false;
                System.out.println("Please enter 1, 2, or 3");
            }
        }
        return input;
    }
}
