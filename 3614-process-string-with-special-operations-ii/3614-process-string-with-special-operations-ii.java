class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] sizes = new long[n];
        long len = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '*') {
                if (len > 0) len--;
            } else if (ch == '#') {
                len *= 2;
            } else if (ch == '%') {
                
            } else {
                len++;
            }

            sizes[i] = len;
        }

        if (k >= len) return '.';

        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            len = sizes[i];

            if (ch == '*') {
                continue;
            } else if (ch == '#') {
                long half = len / 2;
                if (k >= half) {
                    k -= half;
                }
            } else if (ch == '%') {
                k = len - 1 - k;
            } else { 
                if (k == len - 1) {
                    return ch;
                }
            }
        }

        return '.';
    }
}