package LeetCode.ArrayAndTwoPointer.Intervals;

import java.util.Arrays;

/*
* Given an array of meeting intervals where interval[i] = [start, end]
* Return the minimum number of conference room required
* Example:
    intervals = [[0,30], [5,10], [15, 20]] => 2
    intervals = [[7,10], [2,4]] => 1
* */

public class MeetingRoomsII {
    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        int[][] intervals2 = {{7, 10}, {2, 4}};

        System.out.println(conferenceRoomRequired(intervals));
        System.out.println(conferenceRoomRequired(intervals2));

    }

    public static int conferenceRoomRequired(int[][] intervals) {
        int[] start = new int[intervals.length]; // [0, 5, 15]
        int[] end = new int[intervals.length]; // [30, 10, 20]

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start); // [0, 5 , 15]
        Arrays.sort(end); // [10, 20, 30]

        int startIdx = 0;
        int endIdx = 0;

        int noOfConfRoom = 0;

        while (startIdx < start.length) {
            // if meeting starts after end, same room can be used
            if (start[startIdx] >= end[endIdx]) {
                noOfConfRoom--;
                endIdx++;
            }
            noOfConfRoom++;
            startIdx++;
        }

        return noOfConfRoom;
    }
}
