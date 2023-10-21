package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Проверка на строке \"01:00\" ")
    void correctAnswerFor01_00() {
        String time = "01:00";

        int seconds = Task1.getVideoLength(time);

        assertThat(seconds).isEqualTo(60);
    }

    @Test
    @DisplayName("Проверка на строке \"13:56\" ")
    void correctAnswerFor13_56() {
        String time = "13:56";

        int seconds = Task1.getVideoLength(time);

        assertThat(seconds).isEqualTo(836);
    }

    @Test
    @DisplayName("Проверка на строке \"10:60\" ")
    void falseIfSecondsGreaterThan59() {
        String time = "10:60";

        int seconds = Task1.getVideoLength(time);

        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("Проверка на строке \":01\" ")
    void falseIfNoMinutes() {
        String time = ":01";

        int seconds = Task1.getVideoLength(time);

        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("Проверка на строке \"10:\" ")
    void falseIfNoSeconds() {
        String time = "10:";

        int seconds = Task1.getVideoLength(time);

        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("Проверка на строке \"a:10\" ")
    void falseIfAlienSymbol() {
        String time = "a:10";

        int seconds = Task1.getVideoLength(time);

        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("Проверка на строке \"10::10\" ")
    void falseIfDoubleColon() {
        String time = "10::10";

        int seconds = Task1.getVideoLength(time);

        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("Проверка на строке \"1010\" ")
    void falseIfNoColon() {
        String time = "1010";

        int seconds = Task1.getVideoLength(time);

        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("Проверка на строке \"00:00\" ")
    void correctAnswerForZeroes() {
        String time = "00:00";

        int seconds = Task1.getVideoLength(time);

        assertThat(seconds).isEqualTo(0);
    }

    @Test
    @DisplayName("Проверка на строке \"1:1\" ")
    void correctAnswerIfMinutesAndSecondsWithOneSymbol() {
        String time = "1:1";

        int seconds = Task1.getVideoLength(time);

        assertThat(seconds).isEqualTo(61);
    }

    @Test
    @DisplayName("Проверка на пустой строке")
    void falseIfEmptyString() {
        String time = "";

        int seconds = Task1.getVideoLength(time);

        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("Проверка на null строке")
    void falseIfNullString() {
        int seconds = Task1.getVideoLength(null);

        assertThat(seconds).isEqualTo(-1);
    }
}
