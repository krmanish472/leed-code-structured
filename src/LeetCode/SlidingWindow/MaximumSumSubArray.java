package LeetCode.SlidingWindow;

public class MaximumSumSubArray {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;

        int maxSum = maxSum(arr, k);
        System.out.println(maxSum); // => 24
    }

    static int maxSum(int[] arr, int k) {
        int currSum = 0;
        for (int i = 0; i < k; i++) {
            currSum += arr[i];
        }

        int maxSum = currSum;
        int startPtr = 0;
        int endIdx = k;

        while (endIdx < arr.length) {
            currSum += arr[endIdx]; // add next element
            currSum -= arr[startPtr]; // remove prev element

            maxSum = Math.max(currSum, maxSum);

            startPtr++;
            endIdx++;
        }

        return maxSum;
    }
}
