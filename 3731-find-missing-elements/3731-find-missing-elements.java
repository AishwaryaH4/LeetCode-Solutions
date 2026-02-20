import java.util.*;
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
      List<Integer> missing = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        
        for (int n : nums) {
            if (n < min) min = n;
            if (n > max) max = n;
        }

        
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                missing.add(i);
            }
        }

        return missing;  
        
    }
}