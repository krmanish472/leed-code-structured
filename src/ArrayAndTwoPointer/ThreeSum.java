package ArrayAndTwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        // Output: [[-1,-1,2],[-1,0,1]]

        List<List<Integer>> res = threeSum(nums);
        System.out.println(res);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // skip duplicates on first element of triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int leftPtr = i + 1;
            int rightPtr = nums.length - 1;

            while (leftPtr < rightPtr) {
                int sum = nums[i] + nums[leftPtr] + nums[rightPtr];
                if (sum < 0) {
                    leftPtr++;
                } else if (sum > 0) {
                    rightPtr--;
                } else {
                    list.add(Arrays.asList(nums[i], nums[leftPtr], nums[rightPtr]));
                    // there can be another triplets for same i, consider those as well
                    // skip duplicates on left traversal
                    while (leftPtr < rightPtr && nums[leftPtr] == nums[leftPtr + 1]) {
                        leftPtr++;
                    }
                    // skip duplicates on right traversal
                    while (leftPtr < rightPtr && nums[rightPtr] == nums[rightPtr - 1]) {
                        rightPtr--;
                    }

                    leftPtr++;
                    rightPtr--;
                }
            }
        }

        return list;
    }
}
