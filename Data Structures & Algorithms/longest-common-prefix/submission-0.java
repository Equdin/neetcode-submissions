class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int s = strs.length;

        int m = Math.min(strs[0].length(), strs[s - 1].length());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < m; i++) {
            if (strs[0].charAt(i) == strs[s - 1].charAt(i)) {
                result.append(strs[0].charAt(i));
            } else {
                break;
            }
        }

        return result.toString();
    }
}