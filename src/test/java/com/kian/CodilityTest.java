package com.kian;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
    public void test(int[] values, int expectedResult) {
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
    public void test2(int maxValue, int expectedResult) {
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
    public void test3(int[] values, int expectedResult) {
        assertThat(Codility.getSumOfAllNegativeValues(values)).isEqualTo(expectedResult);
    }
}
