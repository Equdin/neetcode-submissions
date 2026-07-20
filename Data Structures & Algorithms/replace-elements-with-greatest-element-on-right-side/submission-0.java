class Solution {
    public int[] replaceElements(int[] arr) {
        int l = arr.length;

        if (l <= 1) {
            return new int[]{-1};
        }

        int max = 0;
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }

            arr[i] = max;
            max = 0;
        }

        arr[l - 1] = -1;
        return arr;
    }
}