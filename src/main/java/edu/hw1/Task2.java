package edu.hw1;

public final class Task2 {
    private static final int NUMBER_SYSTEM = 10;

    private Task2() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static int getNumberOfDigits(long number) {
        if (number == 0) {
            return 1;
        }

        long numberCopy = number;
        int numberOfDigits = 0;

        while (numberCopy != 0) {
            numberOfDigits += 1;
            numberCopy /= NUMBER_SYSTEM;
        }

        return numberOfDigits;
    }
}
