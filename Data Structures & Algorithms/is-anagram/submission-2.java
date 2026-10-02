class Solution {
    public boolean isAnagram(String s, String t) {
        int sl = s.length();
        int tl = t.length();
    
        if (sl != tl) return false;

        Map<Character, Integer> sm = new HashMap<>(sl);
        Map<Character, Integer> tm = new HashMap<>(tl);
        
        for (char c : s.toCharArray()) {
            sm.put(c, sm.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            tm.put(c, tm.getOrDefault(c, 0) + 1);
        }


        return sm.equals(tm);
    }
}
