package LeetCode.ArrayAndTwoPointer.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {2, 6}, {3, 5}, {8, 10}, {15, 18}};
        int[][] mergedIntervals = merge(intervals);

        for (int[] mergedInterval : mergedIntervals) {
            System.out.println(Arrays.toString(mergedInterval));
        }
    }

    public static int[][] merge(int[][] intervals) {
        // sort intervals in asc order
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> mergedList = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int currMin = intervals[i][0]; // X
            int currMax = intervals[i][1]; // Y

            while (i + 1 < intervals.length && currMax >= intervals[i + 1][0]) { // merge only if currMax > nextMin
                currMax = Math.max(currMax, intervals[i + 1][1]);
                i++;
            }

            mergedList.add(new int[]{currMin, currMax});
        }

        return mergedList.toArray(new int[0][]);
    }

}
