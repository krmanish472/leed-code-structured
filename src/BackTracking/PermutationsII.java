package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        //Output: [[1,1,2], [1,2,1], [2,1,1]]

        var res = permuteUnique(nums);
        System.out.println(res);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, result, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    public static void backtrack(int[] nums, List<List<Integer>> result, List<Integer> tempList, boolean[] used) {
        if (tempList.size() == nums.length && !result.contains(tempList)) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            tempList.add(nums[i]);

            backtrack(nums, result, tempList, used);

            used[i] = false;
            tempList.removeLast();
        }
    }

}
