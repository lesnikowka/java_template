package edu.hw1;

public final class Task4 {
    private Task4() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static String getRepairedString(String brokenString) throws NullPointerException {
        if (brokenString == null) {
            throw new NullPointerException("String cannot be null");
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < brokenString.length() - 1; i += 2) {
            builder.append(brokenString.charAt(i + 1));
            builder.append(brokenString.charAt(i));
        }

        if (brokenString.length() % 2 == 1) {
            builder.append(brokenString.charAt(brokenString.length() - 1));
        }

        return builder.toString();
    }
}
