package recursive;

/**
 * @author zhangjin
 * @date 2021-08-08 12:18
 */

import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 如何仅用递归函数和栈操作逆序一个栈
 **/
public class CD7ReverseStack {
    /**
     * 逆序栈
     *
     * @param stack
     */
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty() || stack == null) {
            return;
        }
        Integer e = getAndRemoveLastElement(stack);
        reverseStack(stack);
        stack.push(e);
    }

    private static Integer getAndRemoveLastElement(Stack<Integer> stack) {
        final Integer result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            final Integer last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.addAll(Lists.newArrayList(3, 2, 1));
        System.out.println(stack);
        reverseStack(stack);
        System.out.println(stack);

    }
}
