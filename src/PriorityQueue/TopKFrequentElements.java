package PriorityQueue;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] input = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] res = topKFrequent(input, k);
        System.out.println(Arrays.toString(res));

    }

    public static int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (int key : map.keySet()) {
            pq.add(key);
            if (pq.size() > k) {
                pq.poll(); // [1, 2, 3] - note that this does not consider 1 as small,
                // sorting is on freq map... so element with the least freq will be popped out
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}
