package LeetCode.HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        if (containsDuplicate(nums)) {
            System.out.println("Contains Duplicate");
        } else {
            System.out.println("No Duplicates");
        }
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
