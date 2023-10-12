package edu.hw1;

public class Task4 {
    public String getRepairedString(String brokenString) {
        if (brokenString == null) {
            throw new NullPointerException("String cannot be null");
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < brokenString.length() - 1; i += 2) {
            builder.append(brokenString.charAt(i + 1));
            builder.append(brokenString.charAt(i));
        }

        return builder.toString();
    }
}
