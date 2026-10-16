class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int l = 0;
        int r = n - 1;
        int k = n - 1;
        while (l <= r) {
            int left = (int) Math.pow(nums[l], 2);
            int right = (int) Math.pow(nums[r], 2);

            if (left > right) {
                res[k] = left;
                l++;
            } else {
                res[k] = right;
                r--;
            }

            k--;
        }

        return res;
    }
}