package SlidingWindow;

class PermutationInString {
    public static void main(String[] args) {

    }
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Count frequency of s1
        for (char c : s1.toCharArray()) {
            freq1[c - 'a']++;
        }

        int window = s1.length();

        // First window in s2
        for (int i = 0; i < window; i++) {
            freq2[s2.charAt(i) - 'a']++;
        }

        // Compare first window
        if (matches(freq1, freq2)) return true;

        // Slide through the rest of s2
        for (int i = window; i < s2.length(); i++) {
            freq2[s2.charAt(i) - 'a']++;                    // Add new char
            freq2[s2.charAt(i - window) - 'a']--;           // Remove old char

            if (matches(freq1, freq2)) return true;
        }

        return false;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
