package edu.hw1;

public class Task2 {
    private Task2() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    @SuppressWarnings("MagicNumber")
    public static int getNumberOfDigits(int number) {
        if (number == 0) {
            return 1;
        }

        int numberCopy = number;
        int numberOfDigits = 0;

        while (numberCopy != 0) {
            numberOfDigits += 1;
            numberCopy /= 10;
        }

        return numberOfDigits;
    }
}
