package com.proftelran.org.lessontwentyfour;

import java.util.Arrays;

public class ArrayOperation {

    public int findMax(int... arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException();
        }

        return Arrays.stream(arr).max().getAsInt();
    }

    public int findMin(int... arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException();
        }

        return Arrays.stream(arr).min().getAsInt();
    }
}
