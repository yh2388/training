package yc.algorithm;

import java.util.Stack;

/**
 * 求栈中的最小值/最大值 时间复杂度要求O(1)
 */
public class StackMin {

    static Stack<Integer> stack = new Stack<>();
    static Stack<Integer> minStack = new Stack<>();

    void push(Integer value) {
        stack.push(value);
        if(minStack.isEmpty() || minStack.peek() > value) {
            minStack.push(value);
        }
    }

    Integer pop() {
        if (stack.isEmpty()) {
            return null;
        }
        Integer res = stack.pop();
        if(!minStack.isEmpty() && res.equals(minStack.peek())) {
            minStack.pop();
        }
        return res;
    }

    Integer min() {
        return minStack.isEmpty() ? null : minStack.peek();
    }

    public static void main(String[] args) {
        StackMin stackMin = new StackMin();

        stackMin.push(3);
        stackMin.push(1);
        stackMin.push(2);
        stackMin.push(4);
        System.out.println(stackMin.min());

        stackMin.pop();
        System.out.println(stackMin.min());

        stackMin.pop();
        System.out.println(stackMin.min());

        stackMin.pop();
        System.out.println(stackMin.min());
    }
}
