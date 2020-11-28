package com.kian;

import java.util.Arrays;

public class Codility {
    public static int getMaxOneDigitValue(int[] values) {
        return Arrays.stream(values)
                .filter(v -> v > -10 && v < 10)
                .max()
                .getAsInt();
    }

    public static int getSumOfAllNegativeValues(int[] values) {
        return Arrays.stream(values)
                .filter(v -> v < 0)
                .sum();
    }

    public static int countNumberOfOnes(int max)  {
        int count = 0;
        for (int i = 1; i <= max; i++) {
            String str = String.valueOf(i);
            for (char c: str.toCharArray()) {
                if (c == '1') {
                    count++;
                }
            }
        }
        return count;
    }
}
