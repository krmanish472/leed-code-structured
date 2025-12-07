package Stack;

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

public class NextGreaterElement1 {
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
        // make pair of remainingElements<-> -1
        while (!stack.isEmpty()) {
            nextGreaterMap.put(stack.pop(), -1);
        }


        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.get(nums1[i]);
        }
        return result;
    }

    public static int[] nextGreaterElement_alt(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];

        // store element<->index for nums2
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        // for each element in nums1, find next greater
        for (int i = 0; i < nums1.length; i++) {
            // for number in num1, find the index in num2 and
            // from that index to end, see if there is any greater element
            int idx = map.get(nums1[i]);
            for (int j = idx; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    break;
                } else {
                    res[i] = -1;
                }
            }
        }

        return res;
    }

}
