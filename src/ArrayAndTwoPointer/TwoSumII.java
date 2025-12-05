package ArrayAndTwoPointer;

import java.util.Arrays;

public class TwoSumII {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        int[] res = twoSum(numbers, target);
        System.out.println(Arrays.toString(res));

    }

    public static int[] twoSum(int[] numbers, int target) {
        int leftPtr = 0;
        int rightPtr = numbers.length - 1;

        while (leftPtr < rightPtr) {
            int sum = numbers[leftPtr] + numbers[rightPtr];
            if (sum > target) {
                rightPtr--;
            } else if (sum < target) {
                leftPtr++;
            } else {
                return new int[]{leftPtr + 1, rightPtr + 1};
            }
        }

        return new int[]{};
    }

}
