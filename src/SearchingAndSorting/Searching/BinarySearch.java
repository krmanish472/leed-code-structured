package SearchingAndSorting.Searching;

/*
 * Assumption => array is sorted
 * Get the mid of array, check if the target is equal-to, greater-than or less-than mid-value
 * Completely eliminate one part and Repeat the process for remaining part
 * O(logn)
 * */

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 5, 7, 9, 11};
        int target = 9;

        System.out.println(binarySearch(arr, target));
    }

    private static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int current = arr[mid];

            if (target == current) {
                return mid;
            } else if (target < current) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
