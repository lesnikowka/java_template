package edu.project1;

import org.jetbrains.annotations.NotNull;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;

public class HangmanDictionary implements Dictionary {
    private List<String> dictionary;

    public HangmanDictionary() {
        dictionary = Arrays.asList("hello", "java", "headphones");
    }

    public @NotNull String randomWord() {
        int randomIndex = (int) Math.round(Math.random() * (dictionary.size() - 1));

        return dictionary.get(randomIndex);
    }
}
