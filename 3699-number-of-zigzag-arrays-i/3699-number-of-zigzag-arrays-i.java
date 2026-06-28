class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int mod = 1_000_000_007;
        int m = r - l + 1;
        
        long[][] dp = new long[2][m];
        
        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
            dp[1][i] = 1;
        }
        
        for (int i = 2; i <= n; i++) {
            long[][] nextDp = new long[2][m];
            long[] pref = new long[m + 1];
            
            for (int j = 0; j < m; j++) pref[j + 1] = (pref[j] + dp[0][j]) % mod;
            for (int y = 0; y < m; y++) nextDp[1][y] = pref[y];
            
            long[] suff = new long[m + 1];
            for (int j = m - 1; j >= 0; j--) suff[j] = (suff[j + 1] + dp[1][j]) % mod;
            for (int y = 0; y < m; y++) nextDp[0][y] = suff[y + 1];
            
            dp = nextDp;
        }
        
        long ans = 0;
        for (int i = 0; i < m; i++) {
            ans = (ans + dp[0][i] + dp[1][i]) % mod;
        }
      
        return (int) ans;
    }
}