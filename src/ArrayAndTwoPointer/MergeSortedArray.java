package ArrayAndTwoPointer;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 0, 0, 0};
        int[] arr2 = {2, 5, 6};

        merge(arr1, 3, arr2, 3);
        System.out.println(Arrays.toString(arr1));
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        // start from last index for both arrays
        int mIdx = m - 1;
        int nIdx = n - 1;

        int idx = nums1.length - 1; // fill from last index

        while (nIdx >= 0) {
            if (mIdx >= 0 && nums1[mIdx] > nums2[nIdx]) {
                nums1[idx] = nums1[mIdx];
                mIdx--;
            } else {
                nums1[idx] = nums2[nIdx];
                nIdx--;
            }
            idx--;
        }
    }
}
