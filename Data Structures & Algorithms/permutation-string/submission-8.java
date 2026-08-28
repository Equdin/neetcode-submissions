class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        int matches = 0;

        // edge case
        if (n > s2.length()) {
            return false;
        }

        // first iteration initialising window size
        for (int i = 0; i < n; i++) {
            int c = s1.charAt(i) - 'a';
            int d = s2.charAt(i) - 'a';
            map1[c] += 1;
            map2[d] += 1;
        }

        // initialising the matches
        for (int i = 0; i < 26; i++) {
            if (map1[i] == map2[i]) {
                matches++;
            }
        }

        if (matches == 26) {
            return true;
        }

        // System.out.println(Arrays.toString(map1) + "\n" + Arrays.toString(map2) + "\n" + matches);

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            // check if window size is out of range
            {
                int lc = s2.charAt(l) - 'a';
                
                if (map1[lc] == map2[lc]) {
                    matches--;
                }
                
                map2[lc] -= 1;
                
                if (map1[lc] == map2[lc]) {
                    matches++;
                }

                l++;
            }

            // calculate character count at right pointer
            int rc = s2.charAt(r) - 'a';
            if (map1[rc] == map2[rc]) {
                matches--;
            }

            map2[rc] += 1;
            if (map1[rc] == map2[rc]) {
                matches++;
            } 
            
            if (matches == 26) {
                return true;
            }
        }

        return false;
    }
}
