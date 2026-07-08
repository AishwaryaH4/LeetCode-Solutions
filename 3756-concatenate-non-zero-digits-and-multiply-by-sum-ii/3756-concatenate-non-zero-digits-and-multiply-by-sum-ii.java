import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        List<Integer> pos = new ArrayList<>();
        List<Integer> digit = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                pos.add(i);
                digit.add(d);
            }
        }

        int m = pos.size();

        long[] pow10 = new long[m + 1];
        pow10[0] = 1;
        for (int i = 1; i <= m; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        long[] prefixNum = new long[m + 1];
        int[] prefixSum = new int[m + 1];

        for (int i = 0; i < m; i++) {
            prefixNum[i + 1] = (prefixNum[i] * 10 + digit.get(i)) % MOD;
            prefixSum[i + 1] = prefixSum[i] + digit.get(i);
        }

        int[] left = new int[n];
        int[] right = new int[n];

        int p = 0;
        for (int i = 0; i < n; i++) {
            while (p < m && pos.get(p) < i) p++;
            left[i] = p;
        }

        p = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            while (p >= 0 && pos.get(p) > i) p--;
            right[i] = p;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = left[queries[i][0]];
            int r = right[queries[i][1]];

            if (l > r) {
                ans[i] = 0;
                continue;
            }

            int len = r - l + 1;

            long x = (prefixNum[r + 1] - prefixNum[l] * pow10[len]) % MOD;
            if (x < 0) x += MOD;

            long sum = prefixSum[r + 1] - prefixSum[l];

            ans[i] = (int) (x * sum % MOD);
        }

        return ans;
    }
}