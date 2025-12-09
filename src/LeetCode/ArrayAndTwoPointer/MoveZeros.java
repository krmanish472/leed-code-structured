package LeetCode.ArrayAndTwoPointer;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums)); // [1, 3, 12, 0, 0]
    }

    public static void moveZeroes(int[] nums) {
        int leftIdx = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[leftIdx++] = num;
            }
        }

        while (leftIdx < nums.length) {
            nums[leftIdx++] = 0;
        }
    }

    public void moveZeroes_alt(int[] nums) {
        int leftIdx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != leftIdx) {
                    swap(nums, leftIdx, i);
                }
                leftIdx++;
            }
        }
    }

    private static void swap(int[] arr, int leftIdx, int i) {
        int temp = arr[leftIdx];
        arr[leftIdx] = arr[i];
        arr[i] = temp;
    }

}
