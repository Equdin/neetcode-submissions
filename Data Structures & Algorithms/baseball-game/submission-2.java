class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        for (int i = 0; i < operations.length; i++) {
            String opr = operations[i];

            if (opr.equals("+")) {
                stack.push(stack.get(stack.size() - 1) + stack.get(stack.size() - 2));
                sum += stack.peek();
            } else if (opr.equals("D")) {
                stack.push(2 * stack.peek());
                sum += stack.peek();
            } else if (opr.equals("C")) {
                sum -= stack.peek();
                stack.pop();
            } else {
                stack.push(Integer.valueOf(opr));
                sum += stack.peek();
            }
        }

        return sum;
    }
}