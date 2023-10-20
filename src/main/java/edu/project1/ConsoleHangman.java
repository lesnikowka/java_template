package edu.project1;

import org.jetbrains.annotations.NotNull;
import java.util.Scanner;

class ConsoleHangman {
    public void run(int maxAttempts) {
        if (maxAttempts < 1){
            throw new IllegalArgumentException("Number of attempts cannot be less than 0");
        }

        Scanner in = new Scanner(System.in);

        Dictionary dictionary = new HangmanDictionary();

        Session session = new Session(dictionary.randomWord(), maxAttempts);


        while (true) {
            System.out.println("Guess a letter:");

            String input = in.nextLine().toLowerCase();

            if (!isCorrectInput(input)){
                System.out.println("Incorrect input!");
                continue;
            }

            GuessResult guessResult = tryGuess(session, input);
        }
    }

    private GuessResult tryGuess(Session session, String input) {
        return new GuessResult.Defeat(new char[3], 0, 0, "");
    }

    private void printState(GuessResult guess) {
        System.out.println(guess.message());
    }

    private boolean isCorrectInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!(input.charAt(i) >= 'a' && input.charAt(i) <= 'z')) {
                return false;
            }
        }

        return true;
    }
}
