package edu.hw2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    static Arguments[] rectanglesAndAreas() {
        return new Arguments[] {
            Arguments.of(new int[] {2, 3, 6}),
            Arguments.of(new int[] {2, 0, 0}),
            Arguments.of(new int[] {0, 2, 0}),
        };
    }

    static Arguments[] squaresAndAreas() {
        return new Arguments[] {
            Arguments.of(new int[] {2, 4}),
            Arguments.of(new int[] {0, 0}),
        };
    }

    @ParameterizedTest
    @MethodSource("rectanglesAndAreas")
    void rectangleArea(int[] sizeAndArea) {
        Rectangle rectangle = new Rectangle(sizeAndArea[0], sizeAndArea[1]);

        assertThat(rectangle.area()).isEqualTo(sizeAndArea[2]);
    }

    @ParameterizedTest
    @MethodSource("squaresAndAreas")
    void squareArea(int[] sizeAndArea) {
        Square square = new Square(sizeAndArea[0]);

        assertThat(square.area()).isEqualTo(sizeAndArea[1]);
    }


    @ParameterizedTest
    @MethodSource("squaresAndAreas")
    void squareAreaWithRectangle(int[] sizeAndArea) {
        Rectangle square = new Square(sizeAndArea[0]);

        assertThat(square.area()).isEqualTo(sizeAndArea[1]);
    }
}
