class Fancy {
    private List<Long> nums;
    private List<Long> mults;
    private List<Long> adds;
    private long mul = 1;
    private long add = 0;
    private static final int MOD = 1_000_000_007;

    public Fancy() {
        nums = new ArrayList<>();
        mults = new ArrayList<>();
        adds = new ArrayList<>();
    }

    public void append(int val) {
        nums.add((long) val);
        mults.add(mul);
        adds.add(add);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= nums.size()) return -1;
        
        long m = (mul * modInverse(mults.get(idx))) % MOD;
        long a = (add - (adds.get(idx) * m) % MOD + MOD) % MOD;
        
        return (int) ((nums.get(idx) * m + a) % MOD);
    }

    private long modInverse(long n) {
        return power(n, MOD - 2);
    }

    private long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */