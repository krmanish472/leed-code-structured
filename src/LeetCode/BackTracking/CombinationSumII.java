package LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(nums, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        backtrack(result, new ArrayList<>(), nums, target, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, ArrayList<Integer> current, int[] nums, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;

            if (nums[i] > target) break;

            current.add(nums[i]);
            backtrack(result, current, nums, target - nums[i], i + 1); // Each number may be used only once → i + 1
            current.removeLast();
        }
    }
}
