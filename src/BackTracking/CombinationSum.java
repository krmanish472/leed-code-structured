package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(nums, target));
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, new ArrayList<>(), 0, target);
        return result;
    }

    private static void backtrack(int[] nums, List<List<Integer>> result, List<Integer> current,
                                  int index, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
        } else if (target < 0) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, result, current, i, target - nums[i]);
            current.removeLast();
        }
    }
}
