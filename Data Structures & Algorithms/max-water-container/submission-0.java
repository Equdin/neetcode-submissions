class Solution {
    public int maxArea(int[] heights) {
        int maxAmount = 0;
        int n = heights.length;
        int height = 0;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                height = Math.max((Math.min(heights[i], heights[j]) * Math.abs(i - j)), height);
            }
        }

        return height;
    }
}


/*
1. iterate through the array from left and right
2. calculate height at each step
    i. if height 
height = Math.min(heights[i], heights[j]) * (i - j)
maxAmount = Math.max(height, maxAmount)
*/