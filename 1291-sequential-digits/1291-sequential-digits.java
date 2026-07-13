class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= 9; i++) {
            q.offer(i);
        }

        while (!q.isEmpty()) {
            int num = q.poll();

            if (num >= low && num <= high) {
                ans.add(num);
            }

            int lastDigit = num % 10;
            if (lastDigit < 9) {
                int next = num * 10 + (lastDigit + 1);
                if (next <= high) {
                    q.offer(next);
                }
            }
        }

        return ans;
    }
}