package HashMap;

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
            Arrays.sort(c); // aet, aab

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

    public static List<List<String>> groupAnagrams_withoutSorting(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String key = getFrequencyString(str); // e.g a2b1

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

    public static String getFrequencyString(String str) {
        int[] charCount = new int[26];

        for (char c : str.toCharArray()) {
            charCount[c - 'a']++;
        }

        StringBuilder frequencyString = new StringBuilder();
        char c = 'a';
        for (int i : charCount) {
            frequencyString.append(c);
            frequencyString.append(i);
            c++;
        }

        return frequencyString.toString();

    }
}
