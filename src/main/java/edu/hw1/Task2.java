package edu.hw1;

public class Task2 {
    public int getNumberOfDigits(int number) {
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
