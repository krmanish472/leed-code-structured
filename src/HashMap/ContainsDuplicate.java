package HashMap;

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
            // add will return false, if the element already exists,
            // meaning you found a duplicate
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    // Brute Force
    public static boolean containsDuplicate_bruteForce(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        return freqMap.containsValue(2);
    }
}
