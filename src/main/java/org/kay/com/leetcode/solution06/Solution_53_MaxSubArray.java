package org.kay.com.leetcode.solution06;

public class Solution_53_MaxSubArray {

    public static int maxSubArray(int[] nums) {
        //max就是上面的dp[i]
        int max = nums[0];
        //因为这个dp[i]老是变，所以比如你dp[4]是8 dp[5]就变成-7了，所以需要res保存一下
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max + nums[i], nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}
