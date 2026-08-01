class MinStack {
    Deque<Integer> stack, minStack;
    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(val, minStack.isEmpty() ? val : minStack.peek()));
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/*
create two stacks: one for the stack and another for the min element at each point of the stack
pop and top work using built in functions
getMin pops the most recent MinStack value
*/
