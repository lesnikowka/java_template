package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class Task4Test {
    @Test
    @DisplayName("Проверка для строки четной длины")
    void correctAnswerIfStringLengthIsEven() {
        String source = "hTsii  s aimex dpus rtni.g";
        String expected = "This is a mixed up string.";

        assertThat(Task4.getRepairedString(source)).isEqualTo(expected);
    }

    @Test
    @DisplayName("Проверка для строки нечетной длины")
    void correctAnswerIfStringLengthIsOdd() {
        String source = "hTsii  s aimex dpus rtnig";
        String expected = "This is a mixed up string";

        assertThat(Task4.getRepairedString(source)).isEqualTo(expected);
    }

    @Test
    @DisplayName("Проверка для null")
    void throwIfStringIsNull() {

        assertThatThrownBy(() -> {
            Task4.getRepairedString(null);
        }).isInstanceOf(NullPointerException.class);
    }
}
