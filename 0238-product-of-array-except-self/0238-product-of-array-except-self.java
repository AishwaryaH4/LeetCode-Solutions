class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;
        int div[] = new int[n];
        div[0] = 1;

        for(int i = 1; i < n; i++){
            div[i] = div[i-1] * nums[i-1];
        }

        int count = 1;

        for(int i = n-1; i >= 0; i--){
            div[i] = div[i] * count;
            count = count * nums[i];
        }

        return div;
    }
}