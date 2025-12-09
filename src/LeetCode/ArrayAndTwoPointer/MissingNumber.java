package LeetCode.ArrayAndTwoPointer;

public class MissingNumber {
    public static void main(String[] args) {
        int missingNum = missingNumber(new int[]{3, 0, 1});
        System.out.println(missingNum);
    }

    public static int missingNumber(int[] nums) {
        int xOr = 0;

        for (int i = 0; i <= nums.length; i++) {
            xOr = xOr ^ i;
        }

        for (int num : nums) {
            xOr = xOr ^ num;
        }

        return xOr;
    }
}
