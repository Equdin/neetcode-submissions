class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>(nums.length);

        // sorting the array
        Arrays.sort(nums);

        // traverse the array
        for (int i = 0; i < n - 2; i++) {
            // two pointers
            int l = i + 1;
            int r = n - 1;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                if (sum == 0) {
                    res.add(new ArrayList<>(List.of(nums[i], nums[l], nums[r])));
                    l++;
                    r--;

                    // skip duplicates if any
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                    
                } else if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                }
            }
        }

        return res;
    }
}
