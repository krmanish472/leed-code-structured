package LeetCode.Stack;


import java.util.Arrays;
import java.util.Stack;

/**
 * Input: nums = [1,2,3,4,3] => because circular [1,2,3,4,3,4,3,2,1]
 * Output: [2,3,4,-1,4]
 */
public class NextGreaterElementII {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 3};
        int[] res = nextGreaterElements(nums1);
        System.out.println(Arrays.toString(res));
    }

    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 2 * (nums.length) - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i % n] >= stack.peek()) {
                stack.pop();
            }
            if (i < n) {
                res[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(nums[i % n]);
        }

        return res;
    }
}
