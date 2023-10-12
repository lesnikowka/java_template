package edu.hw1;

import java.util.Arrays;

public class Task6 {
    public int getNumberOfStepsForConstantCaprecar(int number){
        if (number <= 1000 || number >= 10000){
            throw new IllegalArgumentException("Number should be greater than 1000 and less then 10000");
        }

        return makeStep(Integer.toString(number), 0);
    }

    private int makeStep(String currentNumber, int step){
        if (Integer.parseInt(currentNumber) == 6174){
            return step;
        }
        return makeStep(caprecarFunction(currentNumber), step + 1);
    }

    private String caprecarFunction(String number){
        char[] symbols = number.toCharArray();

        Arrays.sort(symbols);

        int minNumber = Integer.parseInt(new String(symbols));
        int maxNumber = Integer.parseInt(new String(reverse(symbols)));

        return Integer.toString(maxNumber - minNumber);
    }

    private char[] reverse(char[] array){
        char[] reversedArray = new char[array.length];

        for (int i = 0; i < array.length / 2; i++){
            int reversedIndex = array.length - i - 1;

            reversedArray[i] = array[reversedIndex];
            reversedArray[reversedIndex] = array[i];
        }

        if (array.length % 2 != 0){
            int mediumIndex = array.length / 2 + 1;
            reversedArray[mediumIndex] = array[mediumIndex];
        }

        return reversedArray;
    }
}
