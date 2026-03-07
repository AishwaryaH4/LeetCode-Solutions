import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int n : nums) {
            pq.add(n);
            if (pq.size() > k) {
                pq.poll();         // remove smallest
            }
        }

        return pq.peek();          // kth largest
    }
}
