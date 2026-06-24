class Solution {
    static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        int states = 2 * m;

        long[][] trans = new long[states][states];

        for (int prev = 0; prev < m; prev++) {
            int upState = prev;
            int downState = prev + m;

            for (int cur = 0; cur < m; cur++) {
                if (cur == prev) continue;

                if (cur < prev) {
                    trans[cur + m][upState]++;
                }

                if (cur > prev) {
                    trans[cur][downState]++;
                }
            }
        }

        long[] init = new long[states];

        for (int a = 0; a < m; a++) {
            for (int b = 0; b < m; b++) {
                if (a == b) continue;

                if (b > a)
                    init[b]++;
                else
                    init[b + m]++;
            }
        }

        if (n == 2) {
            long ans = 0;
            for (long x : init) ans = (ans + x) % MOD;
            return (int) ans;
        }

        long[][] mat = power(trans, n - 2);

        long ans = 0;

        for (int i = 0; i < states; i++) {
            long cur = 0;
            for (int j = 0; j < states; j++) {
                cur = (cur + mat[i][j] * init[j]) % MOD;
            }
            ans = (ans + cur) % MOD;
        }

        return (int) ans;
    }

    private long[][] power(long[][] a, long e) {
        int n = a.length;
        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) res[i][i] = 1;

        while (e > 0) {
            if ((e & 1) == 1) res = multiply(res, a);
            a = multiply(a, a);
            e >>= 1;
        }

        return res;
    }

    private long[][] multiply(long[][] a, long[][] b) {
        int n = a.length;
        long[][] c = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (a[i][k] == 0) continue;
                for (int j = 0; j < n; j++) {
                    if (b[k][j] == 0) continue;
                    c[i][j] = (c[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }

        return c;
    }
}