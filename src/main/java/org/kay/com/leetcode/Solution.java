package org.kay.com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum
 * <p>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;

        int[] sum = twoSum1(nums, target);
        for (int i : sum) {
            System.out.println(i);
        }

        sum = twoSum(nums, target);
        for (int i : sum) {
            System.out.println(i);
        }
    }

    /**
     * Runtime: 22 ms
     * Memory: 38.5 MB
     */
    private static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int k = nums[i] + nums[j];
                if (k == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * Runtime: 3 ms
     * Memory: 38.9 MB
     */
    private static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(2);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
