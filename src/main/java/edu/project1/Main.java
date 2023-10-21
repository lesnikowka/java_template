package edu.project1;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public final class Main {
    public static void main(String[] args) {
        ConsoleHangman consoleHangman = new ConsoleHangman();

        Dictionary dictionary = new HangmanDictionary();


        InputStream inputStream = new ByteArrayInputStream("j\na\nv\na\n".getBytes());

        consoleHangman.run(dictionary.randomWord(), 3, inputStream, System.out);
    }
}
