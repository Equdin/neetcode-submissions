class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length; 
        int sumLeft = 0;
        int sumRight = 0;
        int pivot = 0;

        for (int i = 0; i < n; i++) {
            sumRight = sumRight + nums[i];
        }

        while (pivot < n) {
            if (pivot != 0) {
                sumLeft = sumLeft + nums[pivot - 1];
            }

            sumRight = sumRight - nums[pivot];
            
            if (sumLeft == sumRight) {
                return pivot;
            }

            pivot++;
        }

        return -1;
    }
}