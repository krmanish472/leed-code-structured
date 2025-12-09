package SearchingAndSorting.Sorting;

/*
 * Select a pivot
 * move all nums lower than pivot to left and all nums higher than pivot to right => partitioning
 * create left right pointer => left: if el is larger than pivot, right: if el is smaller than pivot
 * swap elements at left right position
 * if left right are at same, swap pivot with left/right pointer
 * recursively quick sort for left and right partition
 * O(nlogn)
 * */

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 8, 3, 9, 4, 5, 7};
        quicksort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    private static void quicksort(int[] arr, int lowIdx, int highIdx) {
        if (lowIdx >= highIdx) { // sub array of just 1 element
            return;
        }

        int pivot = arr[highIdx];

        int leftPtr = lowIdx;
        int rightPtr = highIdx;

        while (leftPtr < rightPtr) {
            // keep searching for element greater than pivot
            while (arr[leftPtr] <= pivot && leftPtr < rightPtr) {
                leftPtr++;
            }
            // keep searching for element less than pivot
            while (arr[rightPtr] >= pivot && leftPtr < rightPtr) {
                rightPtr--;
            }
            // swap to make smaller element -> left, and greater element -> right
            swap(arr, leftPtr, rightPtr);
        }
        // once left, right meets, swap pivot with left index value
        swap(arr, leftPtr, highIdx);

        // recursively sort 2 half arrays after pivot is in between 2 array
        quicksort(arr, lowIdx, leftPtr - 1);
        quicksort(arr, leftPtr + 1, highIdx);
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
