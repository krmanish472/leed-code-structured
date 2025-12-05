package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        // Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        var result = subsets(nums);
        System.out.println(result);

    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, new ArrayList<>(), 0);
        return result;

    }

    public static void backtrack(int[] nums, List<List<Integer>> result, List<Integer> tempList, int index) {
        result.add(new ArrayList<>(tempList));

        for (int i = index; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(nums, result, tempList, i + 1);
            tempList.removeLast();
        }
    }
}
