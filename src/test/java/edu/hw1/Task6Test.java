package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    @DisplayName("Проверка для 3524")
    void correctAnswerFor3524() {
        assertThat(Task6.getNumberOfStepsForConstantCaprecar(3524)).isEqualTo(3);
    }

    @Test
    @DisplayName("Проверка для 6621")
    void correctAnswerFor6621() {
        assertThat(Task6.getNumberOfStepsForConstantCaprecar(6621)).isEqualTo(5);
    }

    @Test
    @DisplayName("Проверка для 6554")
    void correctAnswerFor6554() {
        assertThat(Task6.getNumberOfStepsForConstantCaprecar(6554)).isEqualTo(4);
    }

    @Test
    @DisplayName("Проверка для 1234")
    void correctAnswerFor1234() {
        assertThat(Task6.getNumberOfStepsForConstantCaprecar(1234)).isEqualTo(3);
    }

    @Test
    @DisplayName("Проверка для 6174")
    void correctAnswerFor6174() {
        assertThat(Task6.getNumberOfStepsForConstantCaprecar(6174)).isEqualTo(0);
    }
}
