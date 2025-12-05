package HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 11, 7, 15};
//        int[] nums = new int[]{3, 2, 4};
        int target = 9;
        int[] arr = twoSum(nums, target);
        System.out.println(Arrays.toString(arr));
    }

    // Hash Table
        public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];

            if (map.containsKey(remainder)) {
                return new int[]{map.get(remainder), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0};
    }

    public static int[] twoSum_x(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], i);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            Integer index = map.get(nums[i]);
            if (index != null && index != i) {
                result[0] = i;
                result[1] = index;
            }
        }
        return result;
    }


    // Brute Force
    public static int[] twoSum_bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0};
    }


}
