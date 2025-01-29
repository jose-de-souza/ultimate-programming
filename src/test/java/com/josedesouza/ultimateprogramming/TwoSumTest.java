package com.josedesouza.ultimateprogramming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    private TwoSum twoSum;

    @BeforeEach
    void init() {
        twoSum = new TwoSum();
    }

    @Test
    void givenTarget9_whenSum_thenReturnArray() {
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] actual = twoSum.solve(numbers, target);
        assertArrayEquals(new int[]{0,1}, actual);
    }

    @Test
    void givenTarget6_whenSum_thenReturnArray() {
        int[] numbers = {3,2,4};
        int target = 6;
        int[] actual = twoSum.solve(numbers, target);
        assertArrayEquals(new int[]{1,2}, actual);
    }

    @Test
    void givenTarget6AndNumbersEqual_whenSum_thenReturnArray() {
        int[] numbers = {3,3};
        int target = 6;
        int[] actual = twoSum.solve(numbers, target);
        assertArrayEquals(new int[]{0,1}, actual);
    }

    @Test
    void givenTarget9AndNumbersLengthIs1_whenSum_thenReturnArray() {
        int[] numbers = {9};
        int target = 9;
        int[] actual = twoSum.solve(numbers, target);
        assertArrayEquals(new int[]{0}, actual);
    }

    @Test
    void givenNumbersIsEmpty_whenSum_thenReturnEmptyArray() {
        int[] numbers = {};
        int target = 0;
        int[] actual = twoSum.solve(numbers, target);
        assertArrayEquals(new int[]{}, actual);
    }

    @Test
    void givenUnexistingTarget_whenSum_thenReturnEmptyArray() {
        int[] numbers = {2,7,11,15};
        int target = 11;
        int[] actual = twoSum.solve(numbers, target);
        assertArrayEquals(new int[]{}, actual);
    }

    @Test
    void givenTarget7AndPairAppartFromEachOther_whenSum_thenReturnArray() {
        int[] numbers = {3,7,11,4,9,18};
        int target = 7;
        int[] actual = twoSum.solve(numbers, target);
        assertArrayEquals(new int[]{0,3}, actual);
    }
}
