package edu.project1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

class ConsoleHangman {
    public final String guessMessage = "Guess a letter:\n";
    public final String incorrectInputMessage = "Incorrect input!\n";
    public final String wordMessage = "Word:\n";
    public final String giveUpCommand = "give up";

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

        GuessResult lastGuessResult = null;

        while (true) {
            if (cannotWriteStringToOutputStream(guessMessage, outputStream)) {
                lastGuessResult = null;
                break;
            }

            String input = getStringFromInputStream(bufferedReader);

            if (input == null) {
                lastGuessResult = null;
                break;
            }

            if (input.equalsIgnoreCase(giveUpCommand)) {
                lastGuessResult = session.giveUp();
                if (!printState(lastGuessResult, outputStream)) {
                    lastGuessResult = null;
                }
                break;
            } else if (!isCorrectInput(input)) {
                if (cannotWriteStringToOutputStream(incorrectInputMessage, outputStream)) {
                    lastGuessResult = null;
                    break;
                }

                continue;
            }

            lastGuessResult = session.guess(input.charAt(0));

            if (!printState(lastGuessResult, outputStream)) {
                lastGuessResult = null;
                break;
            }

            if (lastGuessResult instanceof GuessResult.Win || lastGuessResult instanceof GuessResult.Defeat) {
                break;
            }
        }

        return lastGuessResult;
    }

    private boolean printState(GuessResult guess, OutputStream outputStream) {
        String output = guess.message() + "\n" + wordMessage + new String(guess.state()) + "\n";

        return !cannotWriteStringToOutputStream(output, outputStream);
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
        } catch (java.io.IOException ex) {
            return null;
        }

        return input;
    }

    private boolean cannotWriteStringToOutputStream(String output, OutputStream outputStream) {
        try {
            outputStream.write(output.getBytes(StandardCharsets.UTF_8));
        } catch (java.io.IOException ex) {
            return true;
        }

        return false;
    }
}
