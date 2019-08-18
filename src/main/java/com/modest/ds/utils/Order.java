package com.modest.ds.utils;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * description
 *
 * @author modest
 * @date 2019/08/01
 */
public class Order<T> {
    /**
     * 数组遍历
     * @param arr 要打印的数组
     */
    public static void printIntArray(int[] arr) {
        for (int anArr : arr) {
            System.out.print(anArr);
        }
    }

    /**
     *
     * 前序遍历，递归
     *
     * @param root 树的根节点
     */
    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }

        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历，递归
     * @param root 树的根节点
     */
    public static void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    /**
     *
     * 后序遍历，递归
     * @param root 树的根节点
     */
    public static void postOrder(Node root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    public static void LevelOrder(Node root) {

        if(Objects.isNull(root)) {
            return;
        }

        LinkedList<Node> queue = new LinkedList<Node>();
        Node front = null;
        queue.addLast(root);

        while(queue.size() != 0) {
            front = queue.getFirst();
            queue.removeFirst();

            if(front.left != null) {
                queue.addLast(front.left);
            }

            if(front.right != null) {
                queue.addLast(front.right);
            }
            System.out.print(front.data);
        }
    }


}
