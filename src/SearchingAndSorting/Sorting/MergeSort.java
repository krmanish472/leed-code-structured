package SearchingAndSorting.Sorting;

/*
 * divide array in half, again keep doing half of each partition, until we get atomic partition
 * merge arrays [a,b] [c,d] where a>b and c>d
 * keep merging ...
 * O(logn)
 * */

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 8, 3, 9, 4, 5, 7};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        int length = arr.length;
        if (length < 2) { // check if each array is partitioned to atomic
            return;
        }

        int mid = length / 2;
        int[] leftHalf = new int[mid];
        int[] rightHalf = new int[length - mid];

        for (int i = 0; i < mid; i++) { // populate leftHalf array
            leftHalf[i] = arr[i];
        }
        for (int i = mid; i < length; i++) { // populate rightHalf array
            rightHalf[i - mid] = arr[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(arr, leftHalf, rightHalf);

    }

    private static void merge(int[] arr, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < leftSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                arr[k] = leftHalf[i];
                i++;
            } else {
                arr[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        // clean up to add rest of the elements
        while (i < leftSize) {
            arr[k++] = leftHalf[i++];
        }
        while (j < rightSize) {
            arr[k++] = rightHalf[j++];
        }
    }

}
