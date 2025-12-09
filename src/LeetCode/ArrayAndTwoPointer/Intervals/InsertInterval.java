package LeetCode.ArrayAndTwoPointer.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};

        int[][] res = insert(intervals2, newInterval2);

        for (int[] mergedInterval : res) {
            System.out.println(Arrays.toString(mergedInterval));
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mergedIntervals = new ArrayList<>();

        int i = 0;

        while (i < intervals.length && newInterval[0] > intervals[i][1]) {
            mergedIntervals.add(intervals[i]);
            i++;
        }

        while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        mergedIntervals.add(newInterval);

        while (i < intervals.length) {
            mergedIntervals.add(intervals[i]);
            i++;
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
