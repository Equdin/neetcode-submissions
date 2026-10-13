class Solution {
    public int findPeakElement(int[] nums) {
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];

            if (res[0] < k) {
                res[0] = k;
                res[1] = i;
            }
        }

        return res[1];
    }
}

/*
use two variables - one to keep track of the maximum element and one to keep track of it's index - or else use a int[]
*/