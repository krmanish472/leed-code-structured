package LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        //Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

        var res = permute(nums);
        System.out.println(res);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, result, new ArrayList<>());
        return result;
    }

    public static void backtrack(int[] nums, List<List<Integer>> result, List<Integer> tempList) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int num : nums) {
            if (tempList.contains(num)) {
                continue;
            }

            tempList.add(num);
            backtrack(nums, result, tempList);
            tempList.removeLast();
        }
    }
}
