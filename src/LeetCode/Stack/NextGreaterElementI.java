package LeetCode.Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given:
 * nums1 is a subset of nums2
 * For each element in nums1, find the next greater element to its right in nums2.
 * If none exists → return -1.
 */

public class NextGreaterElementI {
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2}, nums2 = {1, 3, 4, 2};

        int[] res1 = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(res1));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) { // [1,3,4,1,2]
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // make pair of element<->nextGreater
        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                nextGreaterMap.put(stack.pop(), num); // [1-3], [3-4]
            }
            stack.push(num);
        }

        // here stack has elements from nums2, which did not make to map
        // make pair of remainingElements 4, 2 <-> -1
        while (!stack.isEmpty()) {
            nextGreaterMap.put(stack.pop(), -1);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nextGreaterMap.get(nums1[i]);
        }
        return nums1;
    }

}
