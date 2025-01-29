package com.josedesouza.ultimateprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] solve(int[] numbers, int target) {
        //return bruteForce(numbers, target);
        //return binarySearch(numbers, target);
        return optimal(numbers, target);
    }

    /**
     * O(n)
     */
    private int[] optimal(int[] numbers, int target) {
        // Special cases
        if (numbers.length == 1 && numbers[0] == target) {
            return new int[]{0};
        }

        Map<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int other = target - numbers[i];

            if (memo.containsKey(other)) {
                return new int[]{memo.get(other), i};
            }

            memo.put(numbers[i], i);
        }
        return new int[]{};
    }


    private int[] binarySearch(int[] numbers, int target) {
        // Special cases
        if (numbers.length == 0) {
            return new int[]{};
        }

        if (numbers.length == 1 && numbers[0] == target) {
            return new int[]{0};
        }

        if (numbers.length == 2
                && numbers[0] == numbers[1]
                && numbers[0] + numbers[1] == target) {
            return new int[]{0, 1};
        }

        int[] tmp = Arrays.copyOf(numbers, numbers.length);

        // 1 - Sort the input
        Arrays.sort(tmp);

        // 2 - Iterate through the input
        for (int i = 0; i < tmp.length; i++) {
            // 3 - Find the difference between target and value at current index
            int other = target - tmp[i];

            // 4 - Try to find otherIndex through binarySearch
            int otherIndex = Arrays.binarySearch(tmp, other);

            if (otherIndex < 0) {
                continue;
            } else {
                // if found, get the indexes of values and return the pair
                int first = getIndexOf(numbers, tmp[i]);
                int second = getIndexOf(numbers, other);
                return new int[]{first, second};
            }
        }
        return new int[]{};
    }

    private int getIndexOf(int[] arr, int j) {
        for (int i = 0; i < arr.length; i++) {
            // comparing element to the target element
            if (arr[i] == j) {
                return i;
            }
        }
        return -1;
    }

    /**
     * brute force approach
     * problem: it is O(n2)
     */
    private int[] bruteForce(int[] numbers, int target) {
        // Special cases
        if (numbers.length == 0) {
            return new int[]{};
        }

        if (numbers.length == 1 && numbers[0] == target) {
            return new int[]{0};
        }

        if (numbers.length == 2
                && numbers[0] == numbers[1]
                && numbers[0] + numbers[1] == target) {
            return new int[]{0, 1};
        }

        // 1 - Iterate through the input
        for (int i = 0; i < numbers.length; i++) {
            // 2 - Find the difference between target and value at current index
            int other = target - numbers[i];

            // 3 - Look for a value that matches that difference because it is the other number
            // but of course start looking from the next value and not the current one
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] == other) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
