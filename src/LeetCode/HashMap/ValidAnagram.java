package LeetCode.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        if (validAnagram(s, t)) {
            System.out.println("Valid Anagram");
        } else {
            System.out.println("Not Valid Anagram");
        }
    }

    public static boolean validAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCount = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }

        for (int c : charCount) {
            if (c != 0) return false;
        }
        return true;
    }
}
