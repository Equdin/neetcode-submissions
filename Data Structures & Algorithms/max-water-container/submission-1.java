class Solution {
    public int maxArea(int[] heights) {
        int maxAmount = 0;
        int currentAmount = 0;

        int right = heights.length - 1;
        for (int left = 0; left < right;) {
            currentAmount = Math.min(heights[left], heights[right]) * Math.abs(left - right);
            if (heights[left] > heights[right]) {
                right--;
            } else {
                left++;
            }

            maxAmount = Math.max(maxAmount, currentAmount);
        }

        return maxAmount;
    }
}

/*
1. iterate through the array using two pointers
2. heightAmount = Math.min(heights[left], heights[right]) * Math.abs(i - j);
3. maxAmount = Math.max(maxAmount, heightAmount);
3. heights[left] < heights[right] ? left++ : right--;
4. return maxAmount;

*/
