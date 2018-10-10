package cc189.ch3;

import java.util.EmptyStackException;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by xu_xt on 10/9/18.
 */
public class MyQueue<T> {
    Stack<T> inStack;
    Stack<T> outStack;
    MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void add(T object) {
        inStack.push(object);
    }

    public T poll() {
        if (inStack.isEmpty() && outStack.isEmpty()) {
            throw new EmptyStackException();
        }
        if (outStack.isEmpty()) {
            transfer();
        }
        return outStack.pop();
    }

    public T peek() {
        if (inStack.isEmpty() && outStack.isEmpty()) {
            throw new EmptyStackException();
        }
        if (outStack.isEmpty()) {
            transfer();
        }
        return outStack.peek();
    }

    private void transfer(){
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
