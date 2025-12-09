package LeetCode.ArrayAndTwoPointer;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};

        int size = removeDuplicates(arr);
        System.out.println(size);
    }

    public static int removeDuplicates(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            // add 1st elements
            nums[count++] = nums[i];
            // keep moving index pointer until unique is encountered
            while (i < nums.length-1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return count;
    }
}
