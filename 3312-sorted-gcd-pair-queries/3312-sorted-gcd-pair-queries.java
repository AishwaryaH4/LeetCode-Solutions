class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] freq = new int[max + 1];
        for (int num : nums) {
            freq[num]++;
        }

        long[] divCount = new long[max + 1];
        for (int i = 1; i <= max; i++) {
            for (int j = i; j <= max; j += i) {
                divCount[i] += freq[j];
            }
        }

        long[] exactPairs = new long[max + 1];

        for (int i = max; i >= 1; i--) {
            long count = divCount[i];
            long pairs = count * (count - 1) / 2;

            for (int j = i * 2; j <= max; j += i) {
                pairs -= exactPairs[j];
            }

            exactPairs[i] = pairs;
        }

        long[] prefix = new long[max + 1];
        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + exactPairs[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            ans[i] = binarySearch(prefix, queries[i] + 1);
        }

        return ans;
    }

    private int binarySearch(long[] prefix, long target) {
        int left = 1;
        int right = prefix.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (prefix[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}