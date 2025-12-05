package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        // Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

        var res = subsets(nums);
        System.out.println(res);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        backtrack(nums, result, new ArrayList<>(), 0);

        return result;
    }

    public static void backtrack(int[] nums, List<List<Integer>> result, List<Integer> tempList, int index) {
        if (!result.contains(tempList)) {
            result.add(new ArrayList<>(tempList));
        }

        for (int i = index; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(nums, result, tempList, i + 1);
            tempList.removeLast();
        }
    }
}
