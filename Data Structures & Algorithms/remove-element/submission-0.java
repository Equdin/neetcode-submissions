class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length < 1) {
            return 0;
        }
        
        int j = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[j] == val && i < j) {
                j--;
            }

            if (i >= j) {
                break;
            }

            if (nums[i] == val) {
                nums[i] = nums[j];
                nums[j] = val;
            }
        }
        
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                count++;
                System.out.println(count);
            }
        }

        return count;
    }
}