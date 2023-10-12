package edu.hw1;

public class Task1 {
    public int getVideoLength(String notParsed) {
        if (!isCorrectString(notParsed)){
            return -1;
        }

        int colonIndex = notParsed.indexOf(':');

        int minutes = Integer.parseInt(notParsed.substring(0, colonIndex));
        int seconds = Integer.parseInt(notParsed.substring(colonIndex + 1));

        return minutes * 60 + seconds;
    }

    private Boolean isCorrectString(String notParsed) {

        return doesHaveOnlyNumbersAndColon(notParsed) && doesHaveSingleColon(notParsed) &&
            isCorrectNumberSeconds(notParsed);
    }

    private Boolean isCorrectNumberSeconds(String notParsed){
        int colonIndex = notParsed.indexOf(':');

        int seconds = Integer.parseInt(notParsed.substring(colonIndex + 1));

        return seconds < 60;
    }

    private Boolean doesHaveOnlyNumbersAndColon(String notParsed) {
        for (int i = 0; i < notParsed.length(); i++) {
            if (!isNumber(notParsed.charAt(i)) && !isColon(notParsed.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private Boolean doesHaveSingleColon(String notParsed) {
        int firstColonIndex = notParsed.indexOf(':');

        if (firstColonIndex != -1) {
            String cropped = notParsed.substring(firstColonIndex + 1);
            int secondColonIndex = cropped.indexOf(':');

            return secondColonIndex == -1;
        }

        return false;
    }

    private Boolean isNumber(char symbol) {
        return numbers.indexOf(symbol) != -1;
    }

    private Boolean isColon(char symbol) {
        return symbol == ':';
    }

    String numbers = "1234567890";
}
