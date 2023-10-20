package edu.project1;

import org.jetbrains.annotations.NotNull;

sealed interface GuessResult {
    char[] state();
    int attempt();
    int maxAttempts();

    @NotNull String message();

    record Defeat(char[] state, int attempt, int maxAttempts, String message) implements GuessResult {
        public char[] state(){
            return state;
        }
        public int attempt(){
            return attempt;
        }
        public int maxAttempts(){
            return maxAttempts;
        }
        @NotNull public String message(){
            return message;
        }
    }

    record Win(char[] state, int attempt, int maxAttempts, String message) implements GuessResult {
        public char[] state(){
            return state;
        }
        public int attempt(){
            return attempt;
        }
        public int maxAttempts(){
            return maxAttempts;
        }
        @NotNull public String message(){
            return message;
        }
    }

    record SuccessfulGuess(char[] state, int attempt, int maxAttempts, String message) implements GuessResult {
        public char[] state(){
            return state;
        }
        public int attempt(){
            return attempt;
        }
        public int maxAttempts(){
            return maxAttempts;
        }
        @NotNull public String message(){
            return message;
        }
    }

    record FailedGuess(char[] state, int attempt, int maxAttempts, String message) implements GuessResult {
        public char[] state(){
            return state;
        }
        public int attempt(){
            return attempt;
        }
        public int maxAttempts(){
            return maxAttempts;
        }
        @NotNull public String message(){
            return message;
        }
    }
}
