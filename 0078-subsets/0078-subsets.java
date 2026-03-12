import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int idx, int[] nums, List<Integer> curr, List<List<Integer>> ans) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[idx]);
        backtrack(idx + 1, nums, curr, ans);

        curr.remove(curr.size() - 1);
        backtrack(idx + 1, nums, curr, ans);
    }
}
