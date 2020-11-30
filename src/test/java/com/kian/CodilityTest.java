package com.kian;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CodilityTest {
    private static Stream<Arguments> parameter() {
        return Stream.of(
                Arguments.of(new int[] {-66, -9, 0, 3, 10}, 3),
                Arguments.of(new int[] {-9}, -9),
                Arguments.of(new int[] {-9, 2}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameter")
    public void testMaxOneDigitValue(int[] values, int expectedResult) {
        assertThat(Codility.getMaxOneDigitValue(values)).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> parameter2() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(10, 2),
                Arguments.of(100, 21),
                Arguments.of(1000, 301),
                Arguments.of(1111, 448)
        );
    }

    @ParameterizedTest
    @MethodSource("parameter2")
    public void testCountNumberOfOnes(int maxValue, int expectedResult) {
        assertThat(Codility.countNumberOfOnes(maxValue)).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> parameter3() {
        return Stream.of(
                Arguments.of(new int[] {-66, -9, 0, 3, 10}, -75),
                Arguments.of(new int[] {-9}, -9),
                Arguments.of(new int[] {-9, 2}, -9)
        );
    }

    @ParameterizedTest
    @MethodSource("parameter3")
    public void testGetSumOfAllNegativeValues(int[] values, int expectedResult) {
        assertThat(Codility.getSumOfAllNegativeValues(values)).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> parameter4() {
        return Stream.of(
                Arguments.of(1213, 12),
                Arguments.of(1000, 1),
                Arguments.of(0, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameter4")
    public void testCountNumberOfSimilarIntegers(int value, int expectedResult) {
        assertThat(Codility.countNumberOfSimilarIntegers(value)).isEqualTo(expectedResult);
    }

    @Test
    public void testIterator() throws FileNotFoundException {
        final List<Integer> expectedResult = Arrays.asList(2, 3, 1, 0, -1, 100, -321, -1000000000);
        final List<Integer> actualResult = new ArrayList<>();

        final Reader reader = new FileReader("C:\\Users\\ktkwa\\Code\\CodilityTest\\src\\test\\resources\\IteratorTest.txt");
        for (Integer i : new SolutionIter(reader)) {
            actualResult.add(i);
        }
        assertThat(actualResult).containsExactlyElementsOf(expectedResult);
    }
}
