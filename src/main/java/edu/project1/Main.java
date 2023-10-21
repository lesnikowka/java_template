package edu.project1;

public final class Main {
    public static void main(String[] args) {
        ConsoleHangman consoleHangman = new ConsoleHangman();

        Dictionary dictionary = new HangmanDictionary();

        consoleHangman.run(dictionary.randomWord(), 3, System.in, System.out);
    }
}
