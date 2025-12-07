package ArrayAndTwoPointer.Intervals;

import java.util.Arrays;

/*
* Given an array of intervals intervals where intervals[i] = [starti, endi]
* return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
* Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.
    Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
    Output: 1
    Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
* */
public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int count = eraseOverlapIntervals(arr);
        System.out.println(count);
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // [[1,2], [1,3], [2,3], [3,4]]

        int count = 0;
        int currMax = intervals[0][1]; // Y

        for (int i = 1; i < intervals.length; i++) {
            if (currMax > intervals[i][0]) { // is there a merge condition?
                count++; // increase count
                // if currMax(Y) is greater than nextMax => next comparison should be from next entry
                if (currMax > intervals[i][1]) {
                    currMax = intervals[i][1];
                }
            } else {
                currMax = intervals[i][1]; // if not a merge condition, move along
            }
        }
        return count;
    }
}
