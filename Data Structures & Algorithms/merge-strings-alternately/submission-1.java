class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        StringBuilder res = new StringBuilder();

        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            char a = word1.charAt(i);
            char b = word2.charAt(j);

            res.append(a);
            res.append(b);
            i++;
            j++;
        }

        if (i < n) {
            String a = word1.substring(i, n);
            res.append(a);
        }
        
        if (j < m) {
            String b = word2.substring(j, m);
            res.append(b);
        }

        return res.toString();
    }
}