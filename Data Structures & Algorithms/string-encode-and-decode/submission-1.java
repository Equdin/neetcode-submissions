class Solution {

    public String encode(List<String> strs) {
        String encodedString = "";
        
        for (String str : strs) {
            encodedString += str + '!';
        }
        System.out.println(encodedString);
        return encodedString;
    }

    public List<String> decode(String str) {
        List<String> decodedString = new ArrayList<>();

        String strs = "";
        for (char c : str.toCharArray()) {
            
            if (c == '!') {
                decodedString.add(strs);
                strs = "";
                continue;
            }

            strs += c;
        }

        return decodedString;
    }
}
