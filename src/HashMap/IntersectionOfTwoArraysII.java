package HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 9, 5}, nums2 = {9, 4, 9, 8, 4};
        int[] res = intersectionOfTwoArrays(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

    public static int[] intersectionOfTwoArrays(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // Put all the elements of one array in map
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) { // check for value as 4->0 represents it exhausted
                result.add(num);
                map.put(num, map.get(num) - 1); // decrease the count once used to avoid unwanted occurrence
            }
        }

        int[] res = new int[result.size()];
        int idx = 0;
        for (int i : result) {
            res[idx] = i;
            idx++;
        }

        return res;
    }
}
