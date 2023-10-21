package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class Task3Test {
    @Test
    @DisplayName("Проверка для случая, когда второй из массивов пустой")
    void falseIfSecondArrayIsEmpty() {
        Integer[] arr1 = {1, 2};
        Integer[] arr2 = {};

        assertThat(Task3.canBeNested(arr1, arr2)).isFalse();
    }

    @Test
    @DisplayName("Проверка для случая, когда первый из массивов пустой")
    void falseIfFirstArrayIsEmpty() {
        Integer[] arr1 = {};
        Integer[] arr2 = {1, 2};

        assertThat(Task3.canBeNested(arr1, arr2)).isFalse();
    }

    @Test
    @DisplayName("Проверка для случая, когда первый массив может быть вложен во второй")
    void trueIfNestable() {
        Integer[] arr1 = {1, 2, 3, 4};
        Integer[] arr2 = {0, 6};

        assertThat(Task3.canBeNested(arr1, arr2)).isTrue();
    }

    @Test
    @DisplayName("Проверка для случая, когда второй массив имеет длину меньше 2")
    void falseIfSecondArrayLengthLessThan2() {
        Integer[] arr1 = {1, 2, 3, 4};
        Integer[] arr2 = {6};

        assertThat(Task3.canBeNested(arr1, arr2)).isFalse();
    }

    @Test
    @DisplayName("Проверка для случая, когда минимумумы и максимумы массивов равны")
    void falseIfMinAndMaxAreEqual() {
        Integer[] arr1 = {1, 2, 3, 4};
        Integer[] arr2 = {1, 4};

        assertThat(Task3.canBeNested(arr1, arr2)).isFalse();
    }

    @Test
    @DisplayName("Проверка для null")
    void throwIfArrayIsNull() {
        Integer[] arr1 = {1, 2, 3, 4};

        assertThatThrownBy(() -> {
            Task3.canBeNested(arr1, null);
        }).isInstanceOf(NullPointerException.class);
    }
}
