import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        Arrays.fill(result, -1);

        for(int i = 2*n-1; i >= 0; i--) {

            int num = nums[i % n];

            while(!st.isEmpty() && st.peek() <= num){
                st.pop();
            }

            if(i < n){
                if(!st.isEmpty()){
                    result[i] = st.peek();
                }
            }

            st.push(num);
        }

        return result;
    }
}