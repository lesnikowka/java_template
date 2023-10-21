package edu.project1;

import java.util.HashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

class Session {
    private final Set<Character> notGuessedCharacters;
    private final String answer;
    private final char[] state;
    private final int maxAttempts;
    private int attempts;
    private final String notAllowedMessage = "Guess not allowed after the end of the game";
    private final String winMessage = "Win!";
    private final String defeatMessage = "You lost!";
    private final String SuccessfulGuessMessage = "Hit!";

    public Session(String answer, int maxAttempts) {
        this.answer = answer;
        this.maxAttempts = maxAttempts;
        attempts = 0;
        notGuessedCharacters = new HashSet<Character>();
        state = new char[answer.length()];

        for (int i = 0; i < answer.length(); i++) {
            notGuessedCharacters.add(answer.charAt(i));
            state[i] = '*';
        }

    }

    @NotNull GuessResult guess(char guess) {
        if (notGuessedCharacters.isEmpty() || attempts == maxAttempts) {
            throw new IllegalCallerException(notAllowedMessage);
        }

        if (notGuessedCharacters.contains(guess)) {
            notGuessedCharacters.remove(guess);

            changeState(guess);

            if (notGuessedCharacters.isEmpty()) {
                return new GuessResult.Win(state, attempts, maxAttempts, winMessage);
            } else {
                return new GuessResult.SuccessfulGuess(state, attempts, maxAttempts, SuccessfulGuessMessage);
            }

        } else {
            attempts += 1;

            if (attempts == maxAttempts) {
                return new GuessResult.Defeat(state, attempts, maxAttempts, defeatMessage);
            } else {

                String failedMessage = "Missed, mistake "
                    + attempts
                    + " out of "
                    + maxAttempts
                    + ".";

                return new GuessResult.FailedGuess(state, attempts, maxAttempts, failedMessage);
            }
        }

    }

    @NotNull GuessResult giveUp() {
        if (notGuessedCharacters.isEmpty() || attempts == maxAttempts) {
            throw new IllegalCallerException(notAllowedMessage);
        }

        return new GuessResult.Defeat(answer.toCharArray(), attempts, maxAttempts, defeatMessage);
    }

    private void changeState(char guess) {
        for (int i = 0; i < state.length; i++) {
            if (answer.charAt(i) == guess) {
                state[i] = guess;
            }
        }
    }
}
