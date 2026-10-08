class Solution {
    public String largestNumber(int[] nums) {
        // converting int[] to String[]
        int n = nums.length;
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // reordering the String[]
        Arrays.sort(arr, (val1, val2) ->
            (val2 + val1).compareTo(val1 + val2)
        );

        String result = "";

        for (String str : arr) {
            result += str;
        }

        return result.charAt(0) == '0' ? "0" : result;
    }
}