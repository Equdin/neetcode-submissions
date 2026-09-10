class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> indices = new HashMap<>(n);

        // map key(values) to values(indices)
        for (int i = 0; i < n; i++) {
            indices.put(nums[i], i);
        }

        // if diff is present in map and not the same index as i, return it as answer
        for (int i = 0; i < n; i++) {
            int diff = target - nums[i];

            if (indices.containsKey(diff) && indices.get(diff) != i) {
                return new int[] {i, indices.get(diff)};
            }
        }

        return new int[0];
    }
}
