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



    }
}
