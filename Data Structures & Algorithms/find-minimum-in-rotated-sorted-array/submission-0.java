class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int target = nums[0];
        int result = target;

        int low = 1;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int value = nums[mid];

            if (value > target) {
                low = mid + 1;
            } else {
                high = mid - 1;
                result = Math.min(result, value);
            }
        }

        return result;
    }
}
