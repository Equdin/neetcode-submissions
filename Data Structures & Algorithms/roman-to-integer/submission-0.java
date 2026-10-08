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
            char c = s.charAt(i);

            if (i < n - 1) {
                char d = s.charAt(i + 1);
                if (c == 'I') {
                    if (d == 'V') {
                        result += 4;
                        i++;
                        continue;
                    } else if (d == 'X') {
                        result += 9;
                        i++;
                        continue;
                    } else {
                        result += 1;
                        continue;
                    }
                } else if (c == 'X') {
                    if (d == 'L') {
                        result += 40;
                        i++;
                        continue;
                    } else if (d == 'C') {
                        result += 90;
                        i++;
                        continue;
                    } else {
                        result += 10;
                        continue;
                    }
                } else if (c == 'C') {
                    if (d == 'D') {
                        result += 400;
                        i++;
                        continue; 
                    } else if (d == 'M') {
                        result += 900;
                        i++;
                        continue;
                    } else {
                        result += 100;
                        continue;
                    }
                } else {
                    result += values.get(c);
                }
            } else {
                result += values.get(c);
            }
        }

        return result;
    }
}

/*
    1. create a hashmap with the symbol mapped to their values
    2. traverse the string with each character
    3. result += map.get(character)
*/