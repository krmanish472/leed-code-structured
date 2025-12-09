package LeetCode.HashMap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArraysI {
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5}, nums2 = {9, 4, 9, 8, 4};
        int[] res = intersectionOfTwoArrays(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

    public static int[] intersectionOfTwoArrays(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        } // set2 only has common elements now.

        // return as int array
        int[] res = new int[set2.size()];
        int idx = 0;
        for (int el : set2) {
            res[idx] = el;
            idx++;
        }

        return res;
    }
}
