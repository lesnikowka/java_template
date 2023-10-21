package edu.project1;

import org.jetbrains.annotations.NotNull;
import java.util.Locale;
import java.util.Scanner;

class ConsoleHangman {
    public void run(int maxAttempts) {
        if (maxAttempts < 1) {
            throw new IllegalArgumentException("Number of attempts cannot be less than 0");
        }

        Scanner in = new Scanner(System.in);

        Dictionary dictionary = new HangmanDictionary();

        Session session = new Session(dictionary.randomWord(), maxAttempts);

        while (true) {
            System.out.println("Guess a letter:");

            String input = in.nextLine().toLowerCase();

            if (input.equalsIgnoreCase("give up")) {
                printState(session.giveUp());
                break;
            }

            if (!isCorrectInput(input)) {
                System.out.println("Incorrect input!");
                continue;
            }

            GuessResult guessResult = session.guess(input.charAt(0));

            printState(guessResult);

            if (guessResult instanceof GuessResult.Win || guessResult instanceof GuessResult.Defeat) {
                break;
            }
        }
    }

    private void printState(GuessResult guess) {
        System.out.println(guess.message());
        System.out.print("Word: ");
        System.out.println(guess.state());
        System.out.println();
    }

    private boolean isCorrectInput(String input) {
        if (input.length() != 1) {
            return false;
        }

        return input.charAt(0) >= 'a' && input.charAt(0) <= 'z';
    }
}
