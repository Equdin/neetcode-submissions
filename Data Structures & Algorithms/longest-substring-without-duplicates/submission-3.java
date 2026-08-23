class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> map = new HashSet<>(n);
        int max = 0;

        int slow = 0;
        for (int fast = 0; fast < n; fast++) {
            char c = s.charAt(fast);
            
            while (map.contains(c)) {
                map.remove(s.charAt(slow));
                slow++;
            }

            map.add(c);
            max = Math.max(max, fast - slow + 1);
        }

        return max;
    }
}
