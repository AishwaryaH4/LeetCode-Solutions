import java.util.*;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        int LOG = 20;
        int[][] up = new int[n][LOG];

        int r = n - 1;

        for (int l = n - 1; l >= 0; l--) {
            while (pairs[r][0] - pairs[l][0] > maxDiff) {
                r--;
            }

            int u = pairs[l][1];
            int v = pairs[r][1];

            up[u][0] = v;

            for (int k = 1; k < LOG; k++) {
                up[u][k] = up[up[u][k - 1]][k - 1];
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            if (nums[u] > nums[v]) {
                int temp = u;
                u = v;
                v = temp;
            }

            if (u == v) {
                ans[i] = 0;
                continue;
            }

            if (nums[u] == nums[v]) {
                ans[i] = 1;
                continue;
            }

            int steps = 0;

            for (int k = LOG - 1; k >= 0; k--) {
                if (nums[up[u][k]] < nums[v]) {
                    steps += (1 << k);
                    u = up[u][k];
                }
            }

            if (nums[up[u][0]] < nums[v]) {
                ans[i] = -1;
            } else {
                ans[i] = steps + 1;
            }
        }

        return ans;
    }
}