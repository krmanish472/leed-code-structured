package SlidingWindow;

public class MaximumAverageSubArrayI {
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;

        double avg = findMaxAverage(nums, k);
        System.out.println(avg);
    }

    public static double findMaxAverage(int[] arr, int k) {

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

        return (double) maxSum / k;
    }
}
