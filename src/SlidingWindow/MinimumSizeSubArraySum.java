package SlidingWindow;

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

        // start 2 pointers
        int low = 0;
        int high = 0;
        while (high < nums.length) {
            // find current sum and increase window size
            currSum += nums[high];
            high++;

            // try to reduce the window size
            while (currSum >= target) {
                int currWindowLength = high - low;
                minWindowLength = Math.min(minWindowLength, currWindowLength);

                currSum = currSum - nums[low];
                low++;
            }
        }
        return minWindowLength == Integer.MAX_VALUE ? 0 : minWindowLength;
    }
}
