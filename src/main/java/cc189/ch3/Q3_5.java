package cc189.ch3;

import java.util.Stack;

/**
 * Created by xu_xt on 10/9/18.
 */
public class Q3_5 {
    public void sortStack(Stack<Integer> stack) {
        Stack<Integer> buffer = new Stack<>();
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while (!buffer.isEmpty() && buffer.peek() > temp) {
                stack.push(buffer.pop());
            }
            buffer.push(temp);
        }
        while (!buffer.isEmpty()) {
            stack.push(buffer.pop());
        }
    }
}
