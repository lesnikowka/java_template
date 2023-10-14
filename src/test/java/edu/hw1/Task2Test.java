package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Проверка для 0")
    void correctForZero() {
        assertThat(Task2.getNumberOfDigits(0)).isEqualTo(1);
    }

    @Test
    @DisplayName("Проверка для 1")
    void correctForOneDigit() {
        assertThat(Task2.getNumberOfDigits(1)).isEqualTo(1);
    }

    @Test
    @DisplayName("Проверка для 123")
    void correctFor3Digits() {
        assertThat(Task2.getNumberOfDigits(123)).isEqualTo(3);
    }

    @Test
    @DisplayName("Проверка для -123")
    void correctForNegativeNumber() {
        assertThat(Task2.getNumberOfDigits(-123)).isEqualTo(3);
    }
}
