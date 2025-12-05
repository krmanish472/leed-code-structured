package PriorityQueue;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        findKthLargest(nums, k);


    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.add(num);
            // as soon as elements in pq goes beyond 2(i.e. k)
            // remove the smallest element
            if (pq.size() > k) {
                pq.poll(); // this will remove the smallest element as pq stores in sorted order
            }
        }
        // pq has only 2 elements
         return pq.peek(); // this will return the top element (i.e. smallest one)
    }
}
