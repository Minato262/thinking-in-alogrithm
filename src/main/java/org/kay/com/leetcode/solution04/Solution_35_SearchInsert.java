package org.kay.com.leetcode.solution04;

public class Solution_35_SearchInsert {

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length;i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }
}
