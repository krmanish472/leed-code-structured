package Helper;


import java.util.Arrays;
import java.util.Stack;

/**
 * Input: nums = [1,2,3,4,3]
 * Output: [2,3,4,-1,-1]
 */
public class FindNextGreaterElement {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 3};
        int[] res = nextGreaterElements(nums1);
        System.out.println(Arrays.toString(res));
    }

    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= stack.peek()) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }

        return res;
    }
}
