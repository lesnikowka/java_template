package edu.hw2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class Task1Test {

    @Test
    @DisplayName("Проверка константы")
    void isConstantWorking() {
        assertThat(new Expr.Constant(10).evaluate()).isEqualTo(10);
    }

    @Test
    @DisplayName("Проверка смены знака")
    void isNegateWorking() {
        assertThat(new Expr.Negate(new Expr.Constant(-10)).evaluate()).isEqualTo(10);
    }

    @Test
    @DisplayName("Проверка сложения для expr")
    void isAdditionWorkingIfExpr() {
        Expr first = new Expr.Constant(-5);
        Expr second = new Expr.Constant(9);

        assertThat(new Expr.Addition(first, second).evaluate()).isEqualTo(4);
    }

    @Test
    @DisplayName("Проверка сложения когда double первый")
    void isAdditionWorkingIfDoubleFirst() {
        double first = 9;
        Expr second = new Expr.Constant(-5);

        assertThat(new Expr.Addition(first, second).evaluate()).isEqualTo(4);
    }

    @Test
    @DisplayName("Проверка сложения когда double второй")
    void isAdditionWorkingIfDoubleSecond() {
        Expr first = new Expr.Constant(-5);
        double second = 9;

        assertThat(new Expr.Addition(first, second).evaluate()).isEqualTo(4);
    }

    @Test
    @DisplayName("Проверка сложения для double")
    void isAdditionWorkingIfDouble() {
        double first = -5;
        double second = 9;

        assertThat(new Expr.Addition(first, second).evaluate()).isEqualTo(4);
    }

    @Test
    @DisplayName("Проверка умножения для expr")
    void isMultiplicationWorkingIfExpr() {
        Expr first = new Expr.Constant(-5);
        Expr second = new Expr.Constant(9);

        assertThat(new Expr.Multiplication(first, second).evaluate()).isEqualTo(-45);
    }

    @Test
    @DisplayName("Проверка умножения когда double первый")
    void isMultiplicationWorkingIfDoubleFirst() {
        double first = 9;
        Expr second = new Expr.Constant(-5);

        assertThat(new Expr.Multiplication(first, second).evaluate()).isEqualTo(-45);
    }

    @Test
    @DisplayName("Проверка умножения когда double второй")
    void isMultiplicationWorkingIfDoubleSecond() {
        Expr first = new Expr.Constant(-5);
        double second = 9;

        assertThat(new Expr.Multiplication(first, second).evaluate()).isEqualTo(-45);
    }

    @Test
    @DisplayName("Проверка умножения для double")
    void isMultiplicationWorkingIfDouble() {
        double first = -5;
        double second = 9;

        assertThat(new Expr.Multiplication(first, second).evaluate()).isEqualTo(-45);
    }

    @DisplayName("Проверка возведения в степень для expr")
    void isExponentWorkingIfExpr() {
        Expr first = new Expr.Constant(2);
        Expr second = new Expr.Constant(5);

        assertThat(new Expr.Exponent(first, second).evaluate()).isEqualTo(32);
    }

    @Test
    @DisplayName("Проверка возведения в степень когда double первый")
    void isExponentWorkingIfDoubleFirst() {
        double first = 2;
        Expr second = new Expr.Constant(5);

        assertThat(new Expr.Exponent(first, second).evaluate()).isEqualTo(32);
    }

    @Test
    @DisplayName("Проверка возведения в степень когда double второй")
    void isExponentWorkingIfDoubleSecond() {
        Expr first = new Expr.Constant(2);
        double second = 5;

        assertThat(new Expr.Exponent(first, second).evaluate()).isEqualTo(32);
    }

    @Test
    @DisplayName("Проверка возведения в степень для double")
    void isExponentWorkingIfDouble() {
        double first = 2;
        double second = 5;

        assertThat(new Expr.Exponent(first, second).evaluate()).isEqualTo(32);
    }

    @Test
    @DisplayName("Комплексный тест")
    void complexTest() {
        var two = new Expr.Constant(2);
        var four = new Expr.Constant(4);
        var negOne = new Expr.Negate(new Expr.Constant(1));
        var sumTwoFour = new Expr.Addition(two, four);
        var mult = new Expr.Multiplication(sumTwoFour, negOne);
        var exp = new Expr.Exponent(mult, 2);
        var res = new Expr.Addition(exp, new Expr.Constant(1));

        assertThat(res.evaluate()).isEqualTo(37);
    }

}
