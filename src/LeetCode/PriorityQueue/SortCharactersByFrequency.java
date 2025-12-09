package LeetCode.PriorityQueue;

import java.util.*;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s = "tree";
        String res = frequencySort(s);
        System.out.println(res); // Output: "eert"
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
                (a, b) -> freq.get(b) - freq.get(a)
        );

        maxHeap.addAll(freq.keySet());


        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            int count = freq.get(c);
            sb.append(String.valueOf(c).repeat(Math.max(0, count)));
        }

        return sb.toString();
    }
}
