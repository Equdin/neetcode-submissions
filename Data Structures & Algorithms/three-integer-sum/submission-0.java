class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(nums.length);
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int threeSum = nums[i] + nums[left] + nums[right];

                if (threeSum < 0) {
                    left++;
                } else if (threeSum > 0) {
                    right--;
                } else {
                    result.add(new ArrayList<>(List.of(nums[i], nums[left], nums[right])));
                    left++;
                    while (nums[left] == nums[left - 1] && left < right) {
                        left++;
                    }
                }
            }
        }

        return result;
    }
}
