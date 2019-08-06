package com.modest.ds.tree;

import com.modest.ds.utils.TreeNode;

import java.util.LinkedList;

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
        TreeNode front = null;
        while(i<arr.length) {

            front = queue.getFirst();

            if(front.left == null) {

                TreeNode node = new TreeNode(arr[i++]) ;
                front.left = node;
                queue.addLast(front.left);
                if(i == arr.length) {
                    return this.root;
                }
            }
            if(front.right == null){

                TreeNode node = new TreeNode(arr[i++]) ;
                front.right = node;
                queue.addLast(front.right);
                queue.removeFirst();
                if(i == arr.length) {
                    return this.root;
                }
            }
        }
        return this.root;
    }

    public void add(int data) {

    }


}
