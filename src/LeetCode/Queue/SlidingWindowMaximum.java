package LeetCode.Queue;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position               Max
 * ---------------              -----
 * [1  3  -1] -3  5  3  6  7      3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 */

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] result = new int[nums.length - k + 1];

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (!list.isEmpty() && list.getFirst() == i - k) {
                list.removeFirst();
            }
            while (!list.isEmpty() && nums[list.getLast()] < nums[i]) {
                list.removeLast();
            }
            list.add(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[list.getFirst()];
            }
        }

        return result;
    }
}

