class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int l = nums.length;
        int[] result = new int[l];
        int product = 1;

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (i == j) {
                    continue;
                }

                product *= nums[j];
            }

            result[i] = product;
            product = 1;
        }

        return result;
    }
}  
