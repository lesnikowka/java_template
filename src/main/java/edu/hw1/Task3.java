package edu.hw1;

import java.util.Arrays;
import java.util.Collections;

public class Task3 {
    public boolean canBeNested(Integer[] arr1, Integer[] arr2) {
        if (arr1 == null || arr2 == null) {
            throw new NullPointerException("Arrays cannot be null");
        }

        if (arr1.length == 0 || arr2.length < 2) {
            throw new IllegalArgumentException("Incorrect array size");
        }

        int minArray1 = Collections.min(Arrays.asList(arr1));
        int minArray2 = Collections.min(Arrays.asList(arr2));

        int maxArray1 = Collections.max(Arrays.asList(arr1));
        int maxArray2 = Collections.max(Arrays.asList(arr2));

        return minArray1 > minArray2 && maxArray1 < maxArray2;
    }
}
