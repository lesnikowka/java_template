package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    private static void reThrow() {
        int value = 1 / 0;
    }

    @Test
    @DisplayName("Возвращает правильный метод из стека")
    void isCallingInfoCorrect() {
        String className = "";
        String methodName = "";
        try {
            reThrow();
        } catch (Throwable e) {
            className = Task4.callingInfo(e).className();
            methodName = Task4.callingInfo(e).methodName();
        }

        assertThat(className).isEqualTo("com.intellij.rt.junit.JUnitStarter");
        assertThat(methodName).isEqualTo("main");
    }

}
