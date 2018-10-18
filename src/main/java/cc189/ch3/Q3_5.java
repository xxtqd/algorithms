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

    public static void main(String[] args) {
        Q3_5 q = new Q3_5();
        int[] test = new int[]{3,7,2,5,1,7,9,0};
        Stack<Integer> stack = new Stack<>();
        for (int num : test) {
            stack.push(num);
        }
        q.sortStack(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
