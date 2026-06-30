class Solution {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        int i = 0;
        long ans = Long.MIN_VALUE;

        while (i < n) {
            int l = i;
            i++;
            while (i < n && nums[i - 1] < nums[i]) {
                i++;
            }
            if (i == l + 1) {
                continue;
            }

            int p = i - 1;
            long sum = (long) nums[p - 1] + nums[p];

            while (i < n && nums[i - 1] > nums[i]) {
                sum += nums[i];
                i++;
            }

            if (i == p + 1 || i == n || nums[i - 1] == nums[i]) {
                continue;
            }

            int q = i - 1;

            sum += nums[i];
            i++;
            long best = 0;
            long cur = 0;
            while (i < n && nums[i - 1] < nums[i]) {
                cur += nums[i];
                best = Math.max(best, cur);
                i++;
            }
            sum += best;
            best = 0;
            cur = 0;
            for (int j = p - 2; j >= l; j--) {
                cur += nums[j];
                best = Math.max(best, cur);
            }
            sum += best;

            ans = Math.max(ans, sum);
            i = q;
        }

        return ans;
    }
}