package edu.project1;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        ConsoleHangman consoleHangman = new ConsoleHangman();

        Dictionary dictionary = new HangmanDictionary();

        InputStream inputStream = new ByteArrayInputStream("j\na\nv\na\n".getBytes());

        int maxAttempts = 3;

        consoleHangman.run("java", maxAttempts, inputStream, System.out);
    }
}
