package LeetCode.PriorityQueue;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        pq.add(val);
        // as soon as elements in pq goes beyond 2(i.e. k)
        // remove the smallest element
        if (pq.size() > k) {
            pq.poll(); // this will remove the smallest element as pq stores in sorted order
        }

        return pq.peek();
    }
}
