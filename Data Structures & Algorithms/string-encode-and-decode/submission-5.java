class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder(strs.size());
        
        for (String str : strs) {
            encodedString.append(str.length() + "#" + str);
        }

        System.out.println(encodedString.toString());
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedString = new ArrayList<>(str.length());
        int i = 0;

        while (i < str.length()) {
            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.valueOf(str.substring(i, j));

            decodedString.add(str.substring(j + 1, j + 1 + length));
            i = j + 1 + length;
        }

        return decodedString;
    }
}
