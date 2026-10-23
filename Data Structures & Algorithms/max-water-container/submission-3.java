class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int maxAmount = 0;
        int currentAmount = 0;

        int right = n - 1;
        for (int left = 0; left < right;) {
            currentAmount = Math.min(heights[left], heights[right]) * Math.abs(left - right);

            if (heights[left] > heights[right]) {
                right--;
            } else if (heights[right] >= heights[left]) {
                left++;
            }

            maxAmount = Math.max(maxAmount, currentAmount);
        }

        return maxAmount;
    }
}

