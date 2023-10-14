package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {
        LOGGER.info("Hello world!");
    }

    public static void main(String[] args) {
        LOGGER.info("Hello world!");
    }
}
