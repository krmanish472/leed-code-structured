package LeetCode.HashMap;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        System.out.println(result);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c); // aet, aet, ant, aet, ant, abt

            String key = new String(c);

            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> li = new ArrayList<>();
                li.add(str);
                map.put(key, li);
            }
        }

        return new ArrayList<>(map.values());
    }
}
