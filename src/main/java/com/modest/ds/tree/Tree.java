package com.modest.ds.tree;

import com.modest.ds.utils.TreeNode;

import java.util.LinkedList;
import java.util.Objects;

/**
 * description
 *
 * @author modest
 * @date 2019/08/01
 */
public class Tree {

    public TreeNode root;
    private int size = 0;

    public  TreeNode createTree(int[] arr) {
        if(arr.length == 0) {
            return null;
        }

        if(arr.length == 1) {
            this.root = new TreeNode(arr[0]);
            return root;
        }

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        this.root = new TreeNode(arr[0]);
        queue.addLast(this.root );
        int i = 1;
        TreeNode front;
        while(i<arr.length) {

            front = queue.getFirst();

            if(front.left == null) {

                front.left = new TreeNode(arr[i++]);
                queue.addLast(front.left);
                if(i == arr.length) {
                    return this.root;
                }
            }
            if(front.right == null){

                front.right = new TreeNode(arr[i++]);
                queue.addLast(front.right);
                queue.removeFirst();
                if(i == arr.length) {
                    return this.root;
                }
            }
        }
        return this.root;
    }

    public boolean add(int data) {
        if(Objects.isNull(this.root)) {
            this.root = new TreeNode(data);
            this.size++;
            return true;
        }

        TreeNode cur;

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(this.root);

        while(queue.size() != 0) {
            cur = queue.getFirst();
            queue.removeFirst();

            if(cur.left == null) {
                cur.left = new TreeNode(data);
                this.size++;
                return true;
            }
            queue.addLast(cur.left);

            if(cur.right == null) {
                cur.right = new TreeNode(data);
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
