package SlidingWindow;/*
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
        int zeroFlipCount = 0;
        int start = 0;
        int maxOnes = 0;

        for (int end = 0; end < nums.length; end++) { // start and end pointer starts at index 0
            // if 0 is encountered, increase zeroFlipCount
            if (nums[end] == 0) {
                zeroFlipCount++;
            }
            // if number of 0 flipped is greater than k, increase start pointer
            while (zeroFlipCount > k) {
                if (nums[start] == 0) {
                    // decrease zero flipped count if start has 0 as that is not being considered and we can flip 0s again
                    zeroFlipCount--;
                }
                start++;
            }
            // maxOnes will be max found vs currentOnes length
            int currentOnes = end - start + 1;
            maxOnes = Math.max(maxOnes, currentOnes);
        }
        return maxOnes;
    }
}
