import java.util.*;

class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put((long) num, count.getOrDefault((long) num, 0) + 1);
        }

        int maxLen = 0;

        if (count.containsKey(1L)) {
            int ones = count.get(1L);
            if (ones % 2 == 0) ones--;
            maxLen = ones;
        }

        for (long x : count.keySet()) {
            if (x == 1) continue;
            
            long curr = x;
            int len = 0;
            
            while (count.getOrDefault(curr, 0) > 0) {
                if (count.get(curr) >= 2) {
                    len += 2;
                    curr *= curr;
                } else {
                    len += 1;
                    break;
                }
            }
       
            if (count.getOrDefault(curr, 0) == 0 && len > 0) {
                len -= 1;
            }
            
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}