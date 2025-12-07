package Queue;

import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static void main(String[] args) {

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] result = new int[nums.length - k + 1];
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!list.isEmpty() && list.getFirst() == i - k) {
                list.removeFirst();
            }
            while (!list.isEmpty() && nums[list.getLast()] < nums[i]) {
                list.removeLast();
            }
            list.add(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[list.getFirst()];
            }
        }
        return result;
    }
}

