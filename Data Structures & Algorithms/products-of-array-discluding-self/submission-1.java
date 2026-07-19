class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int l = nums.length;
        int[] result = new int[l];
        
        int prefix = 1;
        for (int i = 0; i < l; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for (int j = l - 1; j > -1; j--) {
            result[j] *= postfix;
            postfix *= nums[j];
        }

        return result;
    }
}  
