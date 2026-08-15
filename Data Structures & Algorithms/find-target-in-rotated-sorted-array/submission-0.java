class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int pivot = nums[0];

        int low = 1;
        int high = n - 1;
        int deflection = 0;

        // Find index of smallest element
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = nums[mid];

            if (value >= pivot) {
                low = mid + 1;
            } else {
                deflection = mid;
                high = mid - 1;
            }
        }

        // Search right sorted half
        if (nums[deflection] <= target && target <= nums[n - 1]) {
            low = deflection;
            high = n - 1;
        }
        // Search left sorted half
        else {
            low = 0;
            high = deflection - 1;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}

