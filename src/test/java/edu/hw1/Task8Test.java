package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class Task8Test {
    @Test
    @DisplayName("Проверка на матрице без пересечений коней")
    void trueIfMatrixWithoutKnightIntersections() {
        int[][] board = {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
        };

        assertThat(Task8.allKnightsCannotAttackOtherKnights(board)).isTrue();
    }

    @Test
    @DisplayName("Проверка на матрице c пересечениями коней")
    void falseIfMatrixWithKnightIntersections() {
        int[][] board = {
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}
        };

        assertThat(Task8.allKnightsCannotAttackOtherKnights(board)).isFalse();
    }

    @Test
    @DisplayName("Проверка на нулевой матрице")
    void trueIfNullMatrix() {
        int[][] board = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
        };

        assertThat(Task8.allKnightsCannotAttackOtherKnights(board)).isTrue();
    }

    @Test
    @DisplayName("Проверка на матрице с чередованием элементов")
    void trueIfChessMatrix() {
        int[][] board = {
            {0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0}
        };

        assertThat(Task8.allKnightsCannotAttackOtherKnights(board)).isTrue();
    }

    @Test
    @DisplayName("Проверка на матрице с чередованием элементов и одним пересечением коней")
    void falseIfChessMatrixWithKnightIntersection() {
        int[][] board = {
            {0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0}
        };

        assertThat(Task8.allKnightsCannotAttackOtherKnights(board)).isFalse();
    }

    @Test
    @DisplayName("Проверка на матрице с некорректным размером")
    void throwIfIncorrectMatrixSize() {
        int[][] board = {
            {0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1, 0, 1, 0},
            {1, 0, 1, 0, 1, 0, 1, 0}
        };

        assertThatThrownBy(() -> {
            Task8.allKnightsCannotAttackOtherKnights(board);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Проверка с null")
    void throwIfNullMatrix() {
        assertThatThrownBy(() -> {
            Task8.allKnightsCannotAttackOtherKnights(null);
        }).isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("Проверка на матрице с числом отличным от 1 и 0")
    void throwIfIncorrectMatrixValues() {
        int[][] board = {
            {0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0},
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 2, 1},
            {1, 0, 1, 0, 1, 0, 1, 0},
            {1, 0, 1, 0, 1, 0, 1, 0}
        };

        assertThatThrownBy(() -> {
            Task8.allKnightsCannotAttackOtherKnights(board);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
