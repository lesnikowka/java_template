package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ByteArrayInputStream;

public class Project1Test {
    @Test
    @DisplayName("Проверка на null строке")
    void throwIfNullWord() {
        ConsoleHangman consoleHangman = new ConsoleHangman();

        InputStream inputStream = new ByteArrayInputStream("".getBytes());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        assertThatThrownBy(() -> {
            consoleHangman.run(null, 1, inputStream, outputStream);
        }).isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("Проверка на пустой строке")
    void throwIfEmptyWord() {
        ConsoleHangman consoleHangman = new ConsoleHangman();

        InputStream inputStream = new ByteArrayInputStream("".getBytes());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        assertThatThrownBy(() -> {
            consoleHangman.run("", 1, inputStream, outputStream);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Проверка для null input stream")
    void throwIfNullInputStream() {
        ConsoleHangman consoleHangman = new ConsoleHangman();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        assertThatThrownBy(() -> {
            consoleHangman.run("word", 1, null, outputStream);
        }).isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("Проверка для null output stream")
    void throwIfNullOutputStream() {
        ConsoleHangman consoleHangman = new ConsoleHangman();

        InputStream inputStream = new ByteArrayInputStream("".getBytes());

        assertThatThrownBy(() -> {
            consoleHangman.run("word", 1, inputStream, null);
        }).isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("Поражение если не угадываем максимальное число раз")
    void defeatIfSpendAllAttempts() {
        ConsoleHangman consoleHangman = new ConsoleHangman();

        InputStream inputStream = new ByteArrayInputStream("j\na\ni\ni\ni\n".getBytes());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        assertThat(consoleHangman.run("java", 3, inputStream, outputStream)).isInstanceOf(GuessResult.Defeat.class);
    }

    @Test
    @DisplayName("Успех если угадываем без промахов")
    void winIfGuessAllTimes() {
        ConsoleHangman consoleHangman = new ConsoleHangman();

        InputStream inputStream = new ByteArrayInputStream("j\na\nv\na\n".getBytes());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        assertThat(consoleHangman.run("java", 3, inputStream, outputStream)).isInstanceOf(GuessResult.Win.class);
    }

    @Test
    @DisplayName("Успех если угадываем с промахами")
    void winIfGuessNotAllTimes() {
        ConsoleHangman consoleHangman = new ConsoleHangman();

        InputStream inputStream = new ByteArrayInputStream("k\na\nv\nu\nj\n".getBytes());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        assertThat(consoleHangman.run("java", 3, inputStream, outputStream)).isInstanceOf(GuessResult.Win.class);
    }
}
