package LeetCode.SlidingWindow;

/*
* Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray
* whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Example 1:
    Input: target = 7, nums = [2,3,1,2,4,3]
    Output: 2
    Explanation: The subarray [4,3] has the minimal length under the problem constraint.

* Example 2:
    Input: target = 4, nums = [1,4,4]
    Output: 1

* Example 3:
    Input: target = 11, nums = [1,1,1,1,1,1,1,1]
    Output: 0
* */

// Sliding Window [Variable Size] + 2-pointer
public class MinimumSizeSubArraySum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;

        int res = minSubArrayLen(target, nums);
        System.out.println(res);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int minWindowLength = Integer.MAX_VALUE;

        int currSum = 0;
        int startPtr = 0;
        int endPtr = 0;

        while (endPtr < nums.length) {
            currSum += nums[endPtr];

            while (currSum >= target) {
                minWindowLength = Math.min(minWindowLength, endPtr - startPtr + 1);

                // explore other possibilities
                currSum -= nums[startPtr];
                startPtr++;
            }
            endPtr++;
        }

        return minWindowLength == Integer.MAX_VALUE ? 0 : minWindowLength;
    }
}
