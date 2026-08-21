class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int low = 0;
        int right = 1;

        int max = 0;
        while (right < n) {
            int l = prices[low];
            int r = prices[right];

            if (l < r) {
                max = Math.max(max, r - l);
            } else {
                low = right;
            }

            right++;
        }

        return max;
    }
}
