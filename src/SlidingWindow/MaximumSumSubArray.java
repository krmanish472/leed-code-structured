package SlidingWindow;

public class MaximumSumSubArray {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;

        int maxSum = maxSum(arr, k);
        System.out.println(maxSum);
    }

    static int maxSum(int[] arr, int k) {
        int currSum = 0;
        for (int i = 0; i < k; i++) {
            currSum += arr[i];
        }

        int maxSum = currSum;
        int startIdx = 0;
        int endIdx = k;

        while (endIdx < arr.length) {
            currSum += arr[endIdx]; // add next element
            currSum -= arr[startIdx]; // remove prev element

            maxSum = Math.max(currSum, maxSum);

            startIdx++;
            endIdx++;
        }

        return maxSum;
    }
}
