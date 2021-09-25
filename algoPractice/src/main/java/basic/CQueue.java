package basic;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author zhangjin
 * @date 2021-09-19 17:07
 * 用两个栈模拟队列
 */
class CQueue {
    Stack<Integer> appendStack;
    Stack<Integer> outputStack;

    public CQueue() {
        appendStack = new Stack<>();
        outputStack = new Stack<>();
    }

    public void appendTail(int value) {
        appendStack.add(value);
    }

    public int deleteHead() {
        if (outputStack.isEmpty()) {
            while (!appendStack.isEmpty()) {
                outputStack.add(appendStack.pop());
            }
        }
        if (outputStack.isEmpty()) {
            return -1;
        }
        return outputStack.pop();
    }
}
