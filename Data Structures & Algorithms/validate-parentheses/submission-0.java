class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>(s.length());
        Map<Character, Character> map = new HashMap<>(3);

        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == map.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
