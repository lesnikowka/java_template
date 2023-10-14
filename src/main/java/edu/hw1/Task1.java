package edu.hw1;

public class Task1 {
    @SuppressWarnings("MagicNumber")
    public static int getVideoLength(String notParsed) {
        if (!isCorrectString(notParsed)) {
            return -1;
        }

        int colonIndex = notParsed.indexOf(':');

        int minutes = Integer.parseInt(notParsed.substring(0, colonIndex));
        int seconds = Integer.parseInt(notParsed.substring(colonIndex + 1));

        return minutes * 60 + seconds;
    }

    private static boolean isCorrectString(String notParsed) {

        return doesHaveOnlyNumbersAndColon(notParsed) && doesHaveSingleColon(notParsed)
            && isCorrectNumberSecondsAndMinutes(notParsed);
    }

    @SuppressWarnings("MagicNumber")
    private static boolean isCorrectNumberSecondsAndMinutes(String notParsed) {
        int colonIndex = notParsed.indexOf(':');

        if (colonIndex == 0 && colonIndex == notParsed.length() - 1) {
            return false;
        }

        int seconds = Integer.parseInt(notParsed.substring(colonIndex + 1));

        return seconds < 60;
    }

    private static boolean doesHaveOnlyNumbersAndColon(String notParsed) {
        for (int i = 0; i < notParsed.length(); i++) {
            if (!isNumber(notParsed.charAt(i)) && !isColon(notParsed.charAt(i))) {
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

    @SuppressWarnings("MagicNumber")
    private static boolean isNumber(char symbol) {
        final String numbers = "1234567890";
        return numbers.indexOf(symbol) != -1;
    }

    private static boolean isColon(char symbol) {
        return symbol == ':';
    }
}
