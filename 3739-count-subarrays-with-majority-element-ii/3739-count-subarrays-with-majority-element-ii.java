class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int offset = n + 1;
        int[] bit = new int[2 * n + 2];
        
        java.util.function.BiConsumer<Integer, Integer> update = (idx, val) -> {
            for (; idx < bit.length; idx += idx & -idx) bit[idx] += val;
        };
        
        java.util.function.Function<Integer, Integer> query = (idx) -> {
            int sum = 0;
            for (; idx > 0; idx -= idx & -idx) sum += bit[idx];
            return sum;
        };

        long ans = 0;
        int currentPrefixSum = 0;
        
        update.accept(offset, 1);
        
        for (int num : nums) {
            currentPrefixSum += (num == target ? 1 : -1);
            
            ans += query.apply(currentPrefixSum + offset - 1);
            
            update.accept(currentPrefixSum + offset, 1);
        }
        
        return ans;
    }
}