package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public final class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {
    }

    private static void check(String s){
        s = "asdasdasd";
    }

    public static void main(String[] args) {

        LOGGER.info(Task1.getVideoLength("01:00"));
        LOGGER.info(Task1.getVideoLength("13:56"));
        LOGGER.info(Task1.getVideoLength("10:60"));

        LOGGER.info(Task2.getNumberOfDigits(0));
        LOGGER.info(Task2.getNumberOfDigits(10));
        LOGGER.info(Task2.getNumberOfDigits(123));
        LOGGER.info(Task2.getNumberOfDigits(1));
        LOGGER.info(Task2.getNumberOfDigits(-1));


        Integer[] arr11 = {1, 2, 3, 4};
        Integer[] arr21 = {0, 6};

        LOGGER.info(Task3.canBeNested(arr11, arr21));

        Integer[] arr12 = {1, 2, 3, 4};
        Integer[] arr22 = {0, 6};

        LOGGER.info(Task3.canBeNested(arr12, arr22));


        Integer[] arr13 = {9, 9, 8};
        Integer[] arr23 = {8, 9};

        LOGGER.info(Task3.canBeNested(arr13, arr23));


        Integer[] arr14 = {1, 2, 3, 4};
        Integer[] arr24 = {2, 3};

        LOGGER.info(Task3.canBeNested(arr14, arr24));


        LOGGER.info(Task4.getRepairedString("123456"));
        LOGGER.info(Task4.getRepairedString("hTsii  s aimex dpus rtni.g"));
        LOGGER.info(Task4.getRepairedString("badce"));
        LOGGER.info(Task4.getRepairedString(""));


        LOGGER.info(Task6.getNumberOfStepsForConstantCaprecar(6621));
        LOGGER.info(Task6.getNumberOfStepsForConstantCaprecar(6554));
        LOGGER.info(Task6.getNumberOfStepsForConstantCaprecar(1234));


        LOGGER.info(Task7.rotateRight(8, 1));
        LOGGER.info(Task7.rotateLeft(16, 1));
        LOGGER.info(Task7.rotateLeft(17, 2));

        Task5 Task5 = new Task5();
        LOGGER.info("");
        LOGGER.info(Task5.isSpecialPalindrome(11211230));
        LOGGER.info(Task5.isSpecialPalindrome(13001120));
        LOGGER.info(Task5.isSpecialPalindrome(23336014));
        LOGGER.info(Task5.isSpecialPalindrome(11));
        LOGGER.info(Task5.isSpecialPalindrome(1));
        LOGGER.info(Task5.isSpecialPalindrome(1322));
        LOGGER.info(Task5.isSpecialPalindrome(23229000));


        int[][] board1 = {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
        };

        LOGGER.info("");
        LOGGER.info(Task8.allKnightsCannotAttackOtherKnights(board1));

    }
}
