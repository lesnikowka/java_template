package edu.hw1;

public final class Task1 {
    private static final int NUMBER_SECONDS_IN_MINUTE = 60;

    private Task1() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static int getVideoLength(String notParsed) {
        if (notParsed == null || !isCorrectString(notParsed)) {
            return -1;
        }

        int colonIndex = notParsed.indexOf(':');

        int minutes = Integer.parseInt(notParsed.substring(0, colonIndex));
        int seconds = Integer.parseInt(notParsed.substring(colonIndex + 1));

        return minutes * NUMBER_SECONDS_IN_MINUTE + seconds;
    }

    private static boolean isCorrectString(String notParsed) {

        return doesHaveOnlyNumbersAndColon(notParsed) && doesHaveSingleColon(notParsed)
            && isCorrectNumberSecondsAndMinutes(notParsed);
    }

    private static boolean isCorrectNumberSecondsAndMinutes(String notParsed) {
        int colonIndex = notParsed.indexOf(':');

        if (colonIndex == 0 && colonIndex == notParsed.length() - 1) {
            return false;
        }

        int seconds = Integer.parseInt(notParsed.substring(colonIndex + 1));

        return seconds < NUMBER_SECONDS_IN_MINUTE;
    }

    private static boolean doesHaveOnlyNumbersAndColon(String notParsed) {
        final String NUMBERS = "1234567890";

        for (int i = 0; i < notParsed.length(); i++) {
            if (NUMBERS.indexOf(notParsed.charAt(i)) == -1 && notParsed.charAt(i) != ':') {
                return false;
            }
        }
        return true;
    }

    private static boolean doesHaveSingleColon(String notParsed) {
        int firstColonIndex = notParsed.indexOf(':');

        if (firstColonIndex != 0 && firstColonIndex != notParsed.length() - 1) {
            String cropped = notParsed.substring(firstColonIndex + 1);
            int secondColonIndex = cropped.indexOf(':');

            return secondColonIndex == -1;
        }

        return false;
    }
}
