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

        while (i < n) {
            char a = word1.charAt(i);
            res.append(a);
            i++;
        }


        while (j < m) {
            char b = word2.charAt(j);
            res.append(b);
            j++;
        }

        return res.toString();
    }
}