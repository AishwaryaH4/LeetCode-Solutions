class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int a[] = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = -1;
            for(int j = 1; j < n; j++) {
                int index = (i + j) % n;
                if(nums[index] > nums[i]) {
                    a[i] = nums[index];
                    break;
                }
            }
        }
        return a;
    }
}