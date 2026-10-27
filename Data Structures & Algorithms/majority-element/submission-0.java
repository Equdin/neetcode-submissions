class Solution {
    public int majorityElement(int[] nums) {
        int[] res = new int[]{0, 0};

        for (int i : nums) {
            if (res[1] == 0) {
                res[0] = i;
            }

            if (i == res[0]) {
                res[1]++;
            } else {
                res[1]--;
            }
        }

        return res[0];
    }
}

/*
1. brute force - sort the array and return the no. at [n / 2] + 1
2. optimal - boyer moore
*/