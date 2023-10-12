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
        Task1 task1 = new Task1();

        LOGGER.info(task1.getVideoLength("01:00"));
        LOGGER.info(task1.getVideoLength("13:56"));
        LOGGER.info(task1.getVideoLength("10:60"));

        Task2 task2 = new Task2();

        LOGGER.info(task2.getNumberOfDigits(0));
        LOGGER.info(task2.getNumberOfDigits(10));
        LOGGER.info(task2.getNumberOfDigits(123));
        LOGGER.info(task2.getNumberOfDigits(1));
        LOGGER.info(task2.getNumberOfDigits(-1));

        Task3 task3 = new Task3();

        Integer[] arr11 = {1, 2, 3, 4};
        Integer[] arr21 = {0, 6};

        LOGGER.info(task3.canBeNested(arr11, arr21));

        Integer[] arr12 = {1, 2, 3, 4};
        Integer[] arr22 = {0, 6};

        LOGGER.info(task3.canBeNested(arr12, arr22));


        Integer[] arr13 = {9, 9, 8};
        Integer[] arr23 = {8, 9};

        LOGGER.info(task3.canBeNested(arr13, arr23));


        Integer[] arr14 = {1, 2, 3, 4};
        Integer[] arr24 = {2, 3};

        LOGGER.info(task3.canBeNested(arr14, arr24));

        Task4 task4 = new Task4();

        LOGGER.info(task4.getRepairedString("123456"));
        LOGGER.info(task4.getRepairedString("hTsii  s aimex dpus rtni.g"));
        LOGGER.info(task4.getRepairedString("badce"));
        LOGGER.info(task4.getRepairedString(""));

        Task6 task6 = new Task6();

        LOGGER.info(task6.getNumberOfStepsForConstantCaprecar(6621));
        LOGGER.info(task6.getNumberOfStepsForConstantCaprecar(6554));
        LOGGER.info(task6.getNumberOfStepsForConstantCaprecar(1234));

        Task7 task7 = new Task7();

        LOGGER.info(task7.rotateRight(8, 1));
        LOGGER.info(task7.rotateLeft(16, 1));
        LOGGER.info(task7.rotateLeft(17, 2));

    }
}
