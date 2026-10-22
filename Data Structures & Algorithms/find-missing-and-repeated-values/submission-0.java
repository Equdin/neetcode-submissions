class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] res = new int[2];
        int[] record = new int[n * n];

        for (int i = 0; i < n * n; i++) {
            record[grid[i / n][i % n] - 1]++;
        }

        for (int i = 0; i < record.length; i++) {
            if (record[i] > 1) {
                res[0] = i + 1;
            } else if (record[i] < 1) {
                res[1] = i + 1;
            }
        }

        return res;
    }
}