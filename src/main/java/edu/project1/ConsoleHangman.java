package edu.project1;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

class ConsoleHangman {
    public void run(String word, int maxAttempts, InputStream inputStream, OutputStream outputStream)
        throws NullPointerException, IllegalArgumentException {
        if (word == null) {
            throw new NullPointerException("String cannot be null");
        }
        if (word.isEmpty()) {
            throw new IllegalArgumentException("String cannot be empty");
        }
        if (maxAttempts < 1) {
            throw new IllegalArgumentException("Number of attempts cannot be less than 0");
        }

        Session session = new Session(word, maxAttempts);

        String out;

        while (true) {
            try {
                outputStream.write("Guess a letter:\n".getBytes(StandardCharsets.UTF_8));
            } catch (java.io.IOException ex) {
                return;
            }

            String input;
            if ((input = getStringFromInputStream(inputStream)) == null){
                return;
            }

            if (input.equalsIgnoreCase("give up")) {
                printState(session.giveUp(), outputStream);
                break;
            }

            if (!isCorrectInput(input)) {
                try {
                    outputStream.write("Incorrect input!\n".getBytes(StandardCharsets.UTF_8));
                } catch (java.io.IOException ex) {
                    return;
                }

                continue;
            }

            GuessResult guessResult = session.guess(input.charAt(0));

            printState(guessResult, outputStream);

            if (guessResult instanceof GuessResult.Win || guessResult instanceof GuessResult.Defeat) {
                break;
            }
        }
    }

    private void printState(GuessResult guess, OutputStream outputStream) {
        try {
            outputStream.write((guess.message() + "\n").getBytes(StandardCharsets.UTF_8));

            outputStream.write("Word:\n".getBytes(StandardCharsets.UTF_8));

            outputStream.write((new String(guess.state()) + "\n").getBytes(StandardCharsets.UTF_8));
        } catch (java.io.IOException ex) {
            return;
        }
    }

    private boolean isCorrectInput(String input) {
        if (input.length() != 1) {
            return false;
        }

        return input.charAt(0) >= 'a' && input.charAt(0) <= 'z';
    }

    private String getStringFromInputStream(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String input;

        try {
            input = bufferedReader.readLine();
        }
        catch (java.io.IOException ex) {
            return null;
        }
        return input;
    }
}
