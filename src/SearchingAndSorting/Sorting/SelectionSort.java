package SearchingAndSorting.Sorting;

import java.util.Arrays;

/*
 * take elements one by one from array
 * for each element, keep checking for the lowest number in the array than selected element
 * swap element with min element
 * O(n2)
 *  */

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 1, 2};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIdx = i;

            // loop through to find the smallest
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIdx = j;
                }
            }
            // swap elements to bring smallest first
            swap(arr, i, minIdx);
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
