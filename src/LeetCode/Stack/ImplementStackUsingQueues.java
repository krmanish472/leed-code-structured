package LeetCode.Stack;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        // reverse to get stack structure
        for (int i = 1; i < queue.size(); i++) {
            queue.add(queue.remove());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}


public class ImplementStackUsingQueues {
    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(10);
        obj.push(20);
        obj.push(30);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
    }
}
