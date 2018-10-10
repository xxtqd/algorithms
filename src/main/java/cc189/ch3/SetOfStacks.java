package cc189.ch3;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

/**
 * Created by xu_xt on 10/9/18.
 */
public class SetOfStacks<T> {
    private int stackCapacity;
    private List<Stack<T>> listOfStack;

    // fixme syntax error, constructor does not need generalization
//	public SetOfStacks<T>(int stackCapacity) {
//        listOfStack = new ArrayList<>();
//        this.stackCapacity = stackCapacity;
//    }

    public SetOfStacks(int stackCapacity) {
        this.stackCapacity = stackCapacity;
    }

    public void push(T object) {
        if (listOfStack.isEmpty()){
            listOfStack.add(new Stack<>());
        }
        Stack<T> currentStack = listOfStack.get(listOfStack.size() - 1);
        if (currentStack.size() == stackCapacity) {
            currentStack = new Stack<>();
            listOfStack.add(currentStack);
        }
        currentStack.push(object);
    }

    public T pop() {
        if (listOfStack.isEmpty()) {
            throw new EmptyStackException();
        }
        Stack<T> currentStack = listOfStack.get(listOfStack.size() - 1);
        T result = currentStack.pop();
        if (currentStack.size() == 0) {
            listOfStack.remove(currentStack);
        }
        return result;
    }

    public T popAt(int index) {
        if (index < 0 || index > listOfStack.size() - 1) {
            throw new IndexOutOfBoundsException();
        }
        Stack<T> stack = listOfStack.get(index - 1);
        T result = stack.pop();
        if (stack.isEmpty()) {
            listOfStack.remove(stack);
        }
        return result;
    }
}

