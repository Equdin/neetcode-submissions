class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int left = 0;
        int right = n - 1;
        int leftMax = 0;
        int rightMax = 0;
        int totalAmount = 0;

        // Initialize prefix[] and suffix[]
        for (int k = 0; k < n; k++) {
            leftMax = Math.max(leftMax, height[left]);
            prefix[left] = leftMax;
            left++;

            rightMax = Math.max(rightMax, height[right]);
            suffix[right] = rightMax;
            right--;
        }

        // Calculate totalAmount
        for (int k = 0; k < n; k++) {
            totalAmount += Math.min(prefix[k], suffix[k]) - height[k];
        }

        return totalAmount;
    }
}
