class Solution {
    public int maxProduct(int[] nums) {

        int max = nums[0];
        int min = nums[0];
        int result = nums[0];

        for(int i = 1; i < nums.length; i++){

            if(nums[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            }

            int a = max * nums[i];
            int b = min * nums[i];

            if(nums[i] > a){
                max = nums[i];
            } else {
                max = a;
            }

            if(nums[i] < b){
                min = nums[i];
            } else {
                min = b;
            }

            if(max > result){
                result = max;
            }
        }

        return result;
    }
}