class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0])
        );

        // initialise max and first window
        for (int i = 0; i < k; i++) {
            pq.add(new int[]{nums[i], i});
        }
        result[0] = pq.peek()[0];

        int l = 1;
        for (int r = k; r < n; r++) {
            pq.add(new int[]{nums[r], r});
            
            while (l > pq.peek()[1] && pq.size() > 1) {
                pq.poll();
            }

            result[l] = pq.peek()[0];
            l++;
        }

        return result;
    }
}