package edu.hw1;

import java.lang.Math;

public class Task5 {
    private Task5() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static boolean isSpecialPalindrome(int number) {
        if (isPalindrome(number)) {
            return true;
        }
        if (getLengthOfNumber(number) % 2 == 1) {
            return false;
        }

        int convolutedNumber = getConvoluted(number);

        return isSpecialPalindrome(convolutedNumber);
    }

    private static int getConvoluted(int number) {
        StringBuilder convoluted = new StringBuilder();

        int lengthOfNumber = getLengthOfNumber(number);

        for (int i = 0; i < lengthOfNumber - 1; i += 2) {
            int first = getDigit(number, lengthOfNumber - i - 1);
            int second = getDigit(number, lengthOfNumber - i - 2);
            convoluted.append(first + second);
        }

        return Integer.parseInt(convoluted.toString());
    }

    @SuppressWarnings("MagicNumber")
    private static boolean isPalindrome(int number) {
        final int minimalPalindrome = 11;

        if (number < minimalPalindrome) {
            return false;
        }

        int lengthOfNumber = getLengthOfNumber(number);

        for (int i = 0; i < lengthOfNumber / 2; i++) {
            int reversedIndex = lengthOfNumber - 1 - i;
            int leftDigit = getDigit(number, i);
            int rightDigit = getDigit(number, reversedIndex);

            if (leftDigit != rightDigit) {
                return false;
            }
        }

        return true;
    }

    @SuppressWarnings("MagicNumber")
    private static int getDigit(int number, int place) {
        number %= (int) Math.pow(10, place + 1);
        number /= (int) Math.pow(10, place);

        return number;
    }

    @SuppressWarnings("MagicNumber")
    private static int getLengthOfNumber(int number) {
        if (number == 0) {
            return 1;
        }

        int length = 0;

        while (number != 0) {
            number /= 10;
            length++;
        }

        return length;
    }
}
