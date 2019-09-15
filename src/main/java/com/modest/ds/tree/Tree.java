package com.modest.ds.tree;

import com.modest.ds.utils.Node;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

/**
 * description
 *
 * @author modest
 * @date 2019/08/01
 */
public class Tree {
    public Node root;
    private int size = 0;


    /**
     *
     * @param arr 创建树的数组
     * @return 树的根节点
     */
    public  Node createTree(int[] arr) {
        if(arr.length == 0) {
            return null;
        }

        if(arr.length == 1) {
            this.root = new Node(arr[0]);
            return root;
        }

        LinkedList<Node> queue = new LinkedList<Node>();
        this.root = new Node(arr[0]);
        queue.addLast(this.root );
        int i = 1;
        Node front;
        while(i<arr.length) {

            front = queue.getFirst();

            if(front.left == null) {

                front.left = new Node(arr[i++]);
                queue.addLast(front.left);
                if(i == arr.length) {
                    return this.root;
                }
            }
            if(front.right == null){

                front.right = new Node(arr[i++]);
                queue.addLast(front.right);
                queue.removeFirst();
                if(i == arr.length) {
                    return this.root;
                }
            }
        }
        return this.root;
    }


    /**
     * 中序 后序创建树
     * @param inOrders 中序
     * @param postOrders 后序
     * @return
     */
    public  static Node createTreeByInOrderAndPostOrder(char[] inOrders, char[] postOrders) {

        if(inOrders==null || postOrders== null || inOrders.length==0 || postOrders.length == 0) {
            return null;
        }

        Node root = new Node(postOrders[postOrders.length-1]);
        int i=0;
        for(;i<inOrders.length; i++) {
            if(postOrders[postOrders.length-1] == inOrders[i]) {
                break;
            }
        }

        char[] leftIn = Arrays.copyOfRange(inOrders,0,i);
        char[] leftPost = Arrays.copyOfRange(postOrders,0,i);

        char[] rightIn = Arrays.copyOfRange(inOrders,i+1,inOrders.length);
        char[] rightPost = Arrays.copyOfRange(postOrders,i, postOrders.length-1);

        root.left = createTreeByInOrderAndPostOrder(leftIn,leftPost);
        root.right = createTreeByInOrderAndPostOrder(rightIn, rightPost);
        return root;
    }

    public static Node createTreeByPreOrderAndInOrder(char[] preOrders, char[] inOrders) {

        if(preOrders==null || preOrders== null || inOrders.length==0 || inOrders.length == 0) {
            return null;
        }

        int i=0;
        Node root = new Node(preOrders[0]);

        for(i=0; i<inOrders.length; i++) {
            if(inOrders[i] == preOrders[0]) {
                break;
            }
        }

        char[] leftIn = Arrays.copyOfRange(inOrders, 0, i);
        char[] leftPre = Arrays.copyOfRange(preOrders,1,i+1);

        char[] rightIn = Arrays.copyOfRange(inOrders,i+1,inOrders.length);
        char[] rightPre = Arrays.copyOfRange(preOrders,i+1,preOrders.length);

        root.left = createTreeByPreOrderAndInOrder(leftPre, leftIn);
        root.right = createTreeByPreOrderAndInOrder(rightIn, rightPre);

        return root;
    }
    
    boolean add(int data) {
        if(Objects.isNull(this.root)) {
            this.root = new Node(data);
            this.size++;
            return true;
        }

        Node cur;

        LinkedList<Node> queue = new LinkedList<Node>();
        queue.addLast(this.root);

        while(queue.size() != 0) {
            cur = queue.getFirst();
            queue.removeFirst();

            if(cur.left == null) {
                cur.left = new Node(data);
                this.size++;
                return true;
            }
            queue.addLast(cur.left);

            if(cur.right == null) {
                cur.right = new Node(data);
                this.size++;
                return true;
            }
            queue.addLast(cur.right);
        }

        return false;
    }


    public int getSize() {
        return size;
    }
}
