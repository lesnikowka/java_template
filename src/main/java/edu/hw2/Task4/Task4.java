package edu.hw2.Task4;

public final class Task4 {
    private Task4() {
    }

    public static CallingInfo callingInfo(Throwable e) {

        StackTraceElement[] stackTraceElements = e.getStackTrace();

        StackTraceElement last = stackTraceElements[stackTraceElements.length - 1];

        return new CallingInfo(last.getClassName(), last.getMethodName());
    }

    record CallingInfo(String className, String methodName) {
    }
}
