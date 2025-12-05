package PriorityQueue;

import java.util.*;

public class SortCharactersByFrequency {
    public static void main(String[] args) {

    }

    public String frequencySort(String s) {
        StringBuilder res = new StringBuilder();

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        List<Character> list = new ArrayList<>(freqMap.keySet());
        list.sort((a, b) -> freqMap.get(b) - freqMap.get(a));
        for (char ch : list) {
            for (int i = 0; i < freqMap.get(ch); i++) {
                res.append(ch);
            }
        }
        return res.toString();
    }

    public String frequencySort_alt(String s) {
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
