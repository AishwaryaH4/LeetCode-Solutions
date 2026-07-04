class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> dp = new HashMap<>();

        for (int stone : stones) {
            dp.put(stone, new HashSet<>());
        }

        dp.get(0).add(0);

        for (int stone : stones) {
            for (int jump : dp.get(stone)) {

                for (int nextJump = jump - 1; nextJump <= jump + 1; nextJump++) {

                    if (nextJump > 0 && dp.containsKey(stone + nextJump)) {
                        dp.get(stone + nextJump).add(nextJump);
                    }
                }
            }
        }

        return !dp.get(stones[stones.length - 1]).isEmpty();
    }
}