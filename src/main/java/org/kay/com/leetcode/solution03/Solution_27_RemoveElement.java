package org.kay.com.leetcode.solution03;

public class Solution_27_RemoveElement {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0
                || (nums.length == 1 && nums[0] == val)) {
            return 0;
        }

        int i = 0;
        if (nums[0] == val) {
            nums[0] = nums[1];
            i--;
        }

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != val) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
