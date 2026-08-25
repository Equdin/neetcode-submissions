class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int result = 0;
        Map<Character, Integer> count = new HashMap<>(n);
        
        int l = 0;
        int maxf = 0;
        for (int r = 0; r < n; r++) {
            char right = s.charAt(r);
            char left = s.charAt(l);

            count.put(right, count.getOrDefault(right, 0) + 1);
            maxf = Math.max(maxf, count.get(right));

            while ((r - l + 1) - maxf > k) {
                count.put(left, count.get(left) - 1);
                l++;
            }

            result = Math.max(result, r - l + 1);
        }

        return result;
    }
}
