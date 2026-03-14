import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int result[] = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < 2 * n; i++) {

            int num = nums[i % n];

            while(!st.isEmpty() && nums[st.peek()] < num){
                result[st.pop()] = num;
            }

            if(i < n){
                st.push(i);
            }
        }

        return result;
    }
}