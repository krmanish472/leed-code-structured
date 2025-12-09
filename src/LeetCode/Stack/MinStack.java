package LeetCode.Stack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();

    }

    public void push(int val) {
        stack.push(val);
        // push in min stack, only if it is minimum than prev element
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int poppedValue = stack.pop();
        // pop from minStack as well
        if (poppedValue == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        // because we might have not added some elements in min
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

class DriverClass {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
