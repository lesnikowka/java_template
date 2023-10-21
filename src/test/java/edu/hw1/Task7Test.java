package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Проверка для левого сдвига с одиночным зацикливанем")
    void correctAnswerIfSingleLeftCycling() {
        assertThat(Task7.rotateLeft(8, 2)).isEqualTo(2);
    }

    @Test
    @DisplayName("Проверка для левого сдвига с двойным зацикливанием")
    void correctAnswerIfDoubleLeftCycling() {
        assertThat(Task7.rotateLeft(8, 6)).isEqualTo(2);
    }

    @Test
    @DisplayName("Проверка для правого сдвига без зацикливания")
    void correctAnswerIfRotateRight() {
        assertThat(Task7.rotateRight(12, 1)).isEqualTo(6);
    }

    @Test
    @DisplayName("Проверка для правого сдвига с одиночным зацикливанием")
    void correctAnswerIfSingleRightCycling() {
        assertThat(Task7.rotateRight(8, 5)).isEqualTo(4);
    }

    @Test
    @DisplayName("Проверка для правого сдвига с двойным зацикливанием")
    void correctAnswerIfDoubleRightCycling() {
        assertThat(Task7.rotateRight(8, 9)).isEqualTo(4);
    }
}
