class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> values = new HashMap<>(7);
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);
        
        int result = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int current = values.get(s.charAt(i));

            if (i + 1 < n && current < values.get(s.charAt(i + 1))) {
                result -= current;
            } else {
                result += current;
            }
        }

        return result;
    }
}
