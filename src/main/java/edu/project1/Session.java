package edu.project1;

import org.jetbrains.annotations.NotNull;

class Session {
    private final String answer;
    private final char[] userAnswer;
    private final int maxAttempts;
    private int attempts;

    public Session(String answer, int maxAttempts){
        this.answer = answer;
        userAnswer = new char[maxAttempts];
        this.maxAttempts = maxAttempts;
        attempts = 0;
    }

    @NotNull GuessResult guess(char guess){
        return new GuessResult.Defeat(new char[3], 0, 0, "");
    }
    @NotNull GuessResult giveUp(){
        return new GuessResult.Defeat(new char[3], 0, 0, "");
    }
}
