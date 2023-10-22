package edu.hw2;

record CallingInfo(String className, String methodName) {
}

public class Task4 {
    public static CallingInfo callingInfo(Throwable e) {
        StackTraceElement[] stackTraceElements = e.getStackTrace();

        StackTraceElement last = stackTraceElements[stackTraceElements.length - 1];

        return new CallingInfo(last.getClassName(), last.getMethodName());
    }

}
