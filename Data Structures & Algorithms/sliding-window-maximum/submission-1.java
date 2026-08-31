class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;

        // initialise max and first window
        for (int i = 0; i < k; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        result[0] = max;

        int l = 1;
        for (int r = k; r < n; r++) {
            if (maxIndex < l) {
                max = Integer.MIN_VALUE;
                for (int i = l; i <= r; i++) {
                    if (nums[i] > max) {
                        max = nums[i];
                        maxIndex = i;
                    }
                }
                result[l] = max;              
            }

            if (nums[r] > max) {
                max = nums[r];
                maxIndex = r;
            }
            result[l] = max;

            l++;
        }

        return result;
    }
}