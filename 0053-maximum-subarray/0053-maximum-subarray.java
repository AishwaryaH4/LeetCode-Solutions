class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int sum=0;
        int max=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            if(sum<0){
                sum=nums[i];
            }else{
                sum=sum+nums[i];
            }
            if(sum>max){
                max=sum;
            }
        }
        return max;
    }
}