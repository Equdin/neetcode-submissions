class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;

        // edge cases
        if (t.isEmpty() || s.length() < t.length()) {
            return "";
        }

        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }
        int need = countT.size();

        int have = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char rc = s.charAt(r);
            window.put(rc, window.getOrDefault(rc, 0) + 1);

            if (countT.containsKey(rc) && countT.get(rc).equals(window.get(rc))) {
                have++;
            }

            while (have == need) {
                char lc = s.charAt(l);

                if ((r - l + 1) < resLen) {
                    resLen = (r - l + 1);
                    res[0] = l;
                    res[1] = r;
                }

                window.put(lc, window.get(lc) - 1);

                if (countT.containsKey(lc) && window.get(lc) < countT.get(lc)) {
                    have--;
                }

                l++;
            }
        }

        if (resLen != Integer.MAX_VALUE) {
            return s.substring(res[0], res[1] + 1);
        }

        return "";
    }
}


/*
1. initialise two hashmaps countT and window
2. initialise variable res[] = [-1, -1]. resLen = MAX_VALUE
3. have = 0;
4. traverse string `t` and count the no of all characters.
    need = countT.length()
5. sliding window
    i. l = 0;
    ii. r = 0 till s.length();
    iii. add char at r to window and increment it's value
    iv. if the character is in countT(r) and it has the same value as window(r)
        increment `have` value
    v. while have == need
        a. if window size is less than resLen
            update res = [l, r]
            resLen = new window
        
        b. since we are removing the characters from the left to find smaller window: window[s[l]]--

        c. if countT.contains(s[l]) && windows(s[l]) < countT(s[l])
            have--
        
        d. l++

    vi. return s[res[0], res[1] + 1] if resLen != infinity

6. return "";
*/
