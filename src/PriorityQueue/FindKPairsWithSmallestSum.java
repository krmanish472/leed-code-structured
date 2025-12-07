package PriorityQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSum {
    public static void main(String[] args) {

    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return result;
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < nums1.length && i < k; i++) {
            int sum = nums1[i] + nums2[0];
            minHeap.offer(new int[]{sum, i, 0});
        }


        while (k > 0 && !minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int i = top[1];
            int j = top[2];

            result.add(Arrays.asList(nums1[i], nums2[j]));
            k--;

            if (j + 1 < nums2.length) {
                int nextSum = nums1[i] + nums2[j + 1];
                minHeap.offer(new int[]{nextSum, i, j + 1});
            }
        }

        return result;
    }
}
