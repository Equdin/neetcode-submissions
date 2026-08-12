class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n - 1;

        while (row < m && col > -1) {
            int value = matrix[row][col];

            if (value == target) {
                return true;
            }

            if (value > target) {
                col--;
            } else if (value < target) {
                row++;
            }
        }

        return false;
    }

    public boolean binarySearch(int[][] matrix, int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;
            int value = matrix[low][mid];

            if (value == target) {
                return true;
            }

            if (value < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}
