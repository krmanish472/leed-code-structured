package LeetCode.SlidingWindow;/*
* Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array
* if you can flip at most k 0's.

* Example 1:
    Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
    Output: 6

* Example 2:
    Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
    Output: 10
* */

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;

        int res = longestOnes(nums, k);
        System.out.println(res);
    }

    public static int longestOnes(int[] nums, int k) {
        int flipCount = 0;
        int startPtr = 0;
        int maxOnes = 0;

        for (int endPtr = 0; endPtr < nums.length; endPtr++) {
            // if 0 is encountered, increase flipCount
            if (nums[endPtr] == 0) {
                flipCount++;
            }
            // if number of 0 flipped is greater than k, move start pointer
            while (flipCount > k) {
                if (nums[startPtr] == 0) {
                    flipCount--;
                }
                startPtr++;
            }

            maxOnes = Math.max(maxOnes, endPtr - startPtr + 1);
        }
        return maxOnes;
    }
}
