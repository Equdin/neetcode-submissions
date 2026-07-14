class Solution {

    // 1. for encoding:
    //      

    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return "";
        }
        
        ArrayList<String> stringList = new ArrayList<>(strs.size());
        StringBuilder encodedString = new StringBuilder(strs.size());
        
        for (String str : strs) {
            encodedString.append(str.length() + ",");
            stringList.add(str);
        }
        encodedString.append("#");
        encodedString.append(String.join("", stringList));

        return encodedString.toString();
    }

    public List<String> decode(String str) {

        if (str.length() == 0) {
            return new ArrayList<>();
        }

        List<String> decodedString = new ArrayList<>(str.length());
        List<Integer> stringSizes = new ArrayList<>(str.length());

        int i = 0;
        while (str.charAt(i) != '#') {
            StringBuilder strs = new StringBuilder();
            while (str.charAt(i) != ',') {
                strs.append(str.charAt(i));
                i++;
            }

            stringSizes.add(Integer.parseInt(strs.toString()));
            i++;
        }
        i++;

        for (int sz : stringSizes) {
            decodedString.add(str.substring(i, i + sz));
            i += sz;
        }

        return decodedString;
    }
}