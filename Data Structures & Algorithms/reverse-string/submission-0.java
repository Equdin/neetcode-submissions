class Solution {
    public void reverseString(char[] s) {
        int r = s.length - 1;
        for (int l = 0; l <= r;) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;

            l++;
            r--;
        }
    }
}