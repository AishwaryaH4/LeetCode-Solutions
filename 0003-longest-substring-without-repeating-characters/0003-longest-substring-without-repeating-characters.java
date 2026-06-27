import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        
        int left = 0;
        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            
            if (map.containsKey(currentChar)) {
                left = Math.max(left, map.get(currentChar) + 1);
            }
       
            map.put(currentChar, right);
     
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}