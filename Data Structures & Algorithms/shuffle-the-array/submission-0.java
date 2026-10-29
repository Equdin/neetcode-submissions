class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[n * 2];

        int i = 0;
        int j = n;
        for (int k = 0; k < n * 2; k++) {
            if (k % 2 == 0) {
                ans[k] = nums[i];
                i++;
            } else {
                ans[k] = nums[j];
                j++;
            }
        }

        return ans;
    }
}