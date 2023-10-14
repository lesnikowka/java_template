package edu.hw1;

public final class Task5 {
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
    private static boolean isPalindrome(int sourceNumber) {
        final int minimalPalindrome = 11;

        if (sourceNumber < minimalPalindrome) {
            return false;
        }

        int lengthOfNumber = getLengthOfNumber(sourceNumber);

        for (int i = 0; i < lengthOfNumber / 2; i++) {
            int reversedIndex = lengthOfNumber - 1 - i;
            int leftDigit = getDigit(sourceNumber, i);
            int rightDigit = getDigit(sourceNumber, reversedIndex);

            if (leftDigit != rightDigit) {
                return false;
            }
        }

        return true;
    }

    @SuppressWarnings("MagicNumber")
    private static int getDigit(int sourceNumber, int place) {
        sourceNumber %= (int) Math.pow(10, place + 1);
        sourceNumber /= (int) Math.pow(10, place);

        return sourceNumber;
    }

    @SuppressWarnings("MagicNumber")
    private static int getLengthOfNumber(int sourceNumber) {
        if (sourceNumber == 0) {
            return 1;
        }

        int length = 0;

        while (sourceNumber != 0) {
            sourceNumber /= 10;
            length++;
        }

        return length;
    }
}
