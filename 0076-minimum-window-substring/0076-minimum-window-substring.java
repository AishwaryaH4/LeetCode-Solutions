class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length())
            return "";

        int[] map = new int[128];

        for (char c : t.toCharArray())
            map[c]++;

        int count = t.length();
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {

            if (map[s.charAt(right++)]-- > 0)
                count--;

            while (count == 0) {

                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                if (map[s.charAt(left++)]++ == 0)
                    count++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}