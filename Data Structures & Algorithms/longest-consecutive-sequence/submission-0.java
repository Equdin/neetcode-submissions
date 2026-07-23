class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>(nums.length);
        for (int i : nums) {
            numSet.add(i);
        }

        int longest = 0;

        for (int i : nums) {
            if (!numSet.contains(i - 1)) {
                int length = 0;
                
                while (numSet.contains(i + length)) {
                    length++;
                }

                longest = Math.max(length, longest);
            }
        }

        return longest;
    }
}
