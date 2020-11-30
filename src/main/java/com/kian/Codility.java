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

    public static int countNumberOfSimilarIntegers(int value) {
        int count = 0;
        final String str = String.valueOf(value);
        final char[] charArray = str.toCharArray();
        Arrays.sort(charArray);

        final String minStr = new String(charArray);
        final StringBuilder sb = new StringBuilder(minStr);
        final String maxStr = sb.reverse().toString();

        final int start = Integer.parseInt(minStr);
        final int end = Integer.parseInt(maxStr);
        for (int i = start; i <= end; i++) {
            final String currentStr = String.valueOf(i);
            final char[] currentCharArray = currentStr.toCharArray();
            Arrays.sort(currentCharArray);
            final String sortedStr = new String(currentCharArray);
            if (sortedStr.equals(minStr)) {
                count++;
            }
        }
        return count;
    }
}
