package LeetCode.HashMap;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {2, 3, -5, 5, -5, 1, 4};
        int k = 5;
        int res = subarraySum(nums, k);
        System.out.println(res);
    }

    static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int result = 0;
        int prefixSum = 0;

        for (int num : nums) {
            prefixSum += num;
            result += map.getOrDefault(prefixSum - k, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return result;
    }
}
