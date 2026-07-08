import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        // Prefix sum of digits
        int[] prefixSum = new int[n + 1];

        // Positions and values of non-zero digits
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> val = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            prefixSum[i + 1] = prefixSum[i] + d;
            if (d != 0) {
                pos.add(i);
                val.add(d);
            }
        }

        int m = pos.size();

        long[] pow10 = new long[m + 1];
        pow10[0] = 1;
        for (int i = 1; i <= m; i++)
            pow10[i] = (pow10[i - 1] * 10) % MOD;

        long[] pref = new long[m + 1];
        for (int i = 0; i < m; i++)
            pref[i + 1] = (pref[i] * 10 + val.get(i)) % MOD;

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int left = lowerBound(pos, l);
            int right = upperBound(pos, r);

            if (left == right) {
                ans[i] = 0;
                continue;
            }

            int len = right - left;

            long x = (pref[right] - (pref[left] * pow10[len]) % MOD + MOD) % MOD;
            long sum = prefixSum[r + 1] - prefixSum[l];

            ans[i] = (int) ((x * (sum % MOD)) % MOD);
        }

        return ans;
    }

    private int lowerBound(ArrayList<Integer> arr, int target) {
        int l = 0, r = arr.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr.get(mid) < target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    private int upperBound(ArrayList<Integer> arr, int target) {
        int l = 0, r = arr.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr.get(mid) <= target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}