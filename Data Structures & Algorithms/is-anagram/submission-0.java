class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map1 = new HashMap<>(s.length());

        if (s.length() != t.length()) {
            return false;
        }

        for(char c : s.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!map1.containsKey(c)) {
                return false;
            }

            map1.put(c, map1.get(c) - 1);

            if (map1.get(c) < 0) {
                return false;
            }
        }

        return true;
    }
}