package cc189.ch3;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by xu_xt on 10/8/18.
 */
public class Q3_2 extends Stack<Integer> {
    Stack<Integer> minStack;
    Q3_2() {
        minStack = new Stack<>();
    }
    public Integer pop() {
        Integer value = super.pop();
        if (value == min()) {
            minStack.pop();
        }
        return value;
    }

    public void push(int num) {
        super.push(num);
        if (minStack.isEmpty() || num <= min()) { // fixme consider edge case, what if multiple integer of same value are pushed to stack??
            minStack.push(num);
        }
    }

    public int min() {
        if (minStack.isEmpty()) {
            throw new EmptyStackException();
        }
        return minStack.peek();
    }

}
