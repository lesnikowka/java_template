package edu.project1;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

class ConsoleHangman {
    public GuessResult run(String word, int maxAttempts, InputStream inputStream, OutputStream outputStream)
        throws NullPointerException, IllegalArgumentException {
        if (word == null || inputStream == null || outputStream == null) {
            throw new NullPointerException("Arguments cannot be null");
        }
        if (word.isEmpty()) {
            throw new IllegalArgumentException("String cannot be empty");
        }
        if (maxAttempts < 1) {
            throw new IllegalArgumentException("Number of attempts cannot be less than 0");
        }

        Session session = new Session(word, maxAttempts);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        GuessResult lastGuessResult  = null;

        while (true) {
            try {
                outputStream.write("Guess a letter:\n".getBytes(StandardCharsets.UTF_8));
            } catch (java.io.IOException ex) {
                return null;
            }

            String input;
            if ((input = getStringFromInputStream(bufferedReader)) == null){
                return null;
            }

            if (input.equalsIgnoreCase("give up")) {
                printState(session.giveUp(), outputStream);
                break;
            }

            if (!isCorrectInput(input)) {
                try {
                    outputStream.write("Incorrect input!\n".getBytes(StandardCharsets.UTF_8));
                } catch (java.io.IOException ex) {
                    return null;
                }

                continue;
            }

            lastGuessResult = session.guess(input.charAt(0));

            printState(lastGuessResult, outputStream);

            if (lastGuessResult instanceof GuessResult.Win || lastGuessResult instanceof GuessResult.Defeat) {
                break;
            }
        }

        return lastGuessResult;
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

    private String getStringFromInputStream(BufferedReader bufferedReader) {

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
