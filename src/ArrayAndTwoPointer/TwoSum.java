package ArrayAndTwoPointer;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 11, 7, 15};
        int target = 9;

        int[] arr = twoSum(nums, target);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            // get complement & check if its already present
            // if present, result will be that number's index and complement's index
            int compliment = target - arr[i];
            if (map.containsKey(compliment)) {
                return new int[]{map.get(compliment), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{};
    }
}
