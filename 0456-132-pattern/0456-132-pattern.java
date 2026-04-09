import java.util.*;

class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int second = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i = n-1; i >= 0; i--) {
            // Check 132 pattern
            if (nums[i] < second) {
                return true;
            }

            // Maintain decreasing stack
            while (!st.isEmpty() && nums[i] > st.peek()) {
                second = st.pop();
            }

            st.push(nums[i]);
        }

        return false;
    }
}