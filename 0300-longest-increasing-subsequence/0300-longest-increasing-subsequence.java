import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {

        List<Integer> tails = new ArrayList<>();

        for (int num : nums) {

            int left = 0, right = tails.size();

            // Binary search
            while (left < right) {
                int mid = (left + right) / 2;

                if (tails.get(mid) < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            // Replace or add
            if (left == tails.size()) {
                tails.add(num);
            } else {
                tails.set(left, num);
            }
        }

        return tails.size();
    }
}