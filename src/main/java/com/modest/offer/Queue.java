package com.modest.offer;

import java.util.Stack;

/**
 * 两个栈实现队列
 *
 * @author modest
 * @date 2019/09/14
 */
public class Queue {
    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        if(stack2 == null || stack2.size() == 0) {
            stack1.push(node);
        }else {
            while(stack2.size() != 0){
                int a = stack2.pop();
                stack1.push(a);
            }

            stack1.push(node);

        }
    }

    public int pop() {
        while(stack1.size() != 0) {
            int a = stack1.pop();
            stack2.push(a);
        }

        return stack2.pop();
    }
}
