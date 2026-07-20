class Solution {
    public int[] replaceElements(int[] arr) {
        int l = arr.length;

        if (l <= 1) {
            return new int[]{-1};
        }

        int rightMax = -1;
        int newMax;
        for (int i = l - 1; i > -1; i--) {
            newMax = Math.max(arr[i], rightMax);
            arr[i] = rightMax;
            rightMax = newMax;
        }

        return arr;
    }
}