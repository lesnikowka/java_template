package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    @DisplayName("Проверка для изначального палиндрома нечетной длины")
    void trueIfOddNumberIsPalindrome() {
        assertThat(Task5.isSpecialPalindrome(101)).isTrue();
    }

    @Test
    @DisplayName("Проверка для числа нечетной длины, не являющегося палидромом")
    void trueIfOddNumberIsNotPalindrome() {
        assertThat(Task5.isSpecialPalindrome(102)).isFalse();
    }

    @Test
    @DisplayName("Проверка для изначального палиндрома нечетной длины")
    void trueIfEvenNumberIsPalindrome() {
        assertThat(Task5.isSpecialPalindrome(1001)).isTrue();
    }

    @Test
    @DisplayName("Проверка для числа длины 1")
    void falseIfEvenNumberLengthIs1() {
        assertThat(Task5.isSpecialPalindrome(1)).isFalse();
    }

    @Test
    @DisplayName("Проверка для числа длины 2, не являющегося палиндромом")
    void falseIfNumberWith2DigitsIsNotPalindrome() {
        assertThat(Task5.isSpecialPalindrome(12)).isFalse();
    }

    @Test
    @DisplayName("Проверка для числа длины 2, являющегося палиндромом")
    void TrueIfNumberWith2DigitsIsPalindrome() {
        assertThat(Task5.isSpecialPalindrome(22)).isTrue();
    }

    @Test
    @DisplayName("Проверка для особого палиндрома без переполнений")
    void trueIfSpecialPalindromeWithoutOverflow() {
        assertThat(Task5.isSpecialPalindrome(11211230)).isTrue();
    }

    @Test
    @DisplayName("Проверка для особого палиндрома с переполнением")
    void trueIfSpecialPalindromeWithOverflow() {
        assertThat(Task5.isSpecialPalindrome(651192)).isTrue();
    }
}
