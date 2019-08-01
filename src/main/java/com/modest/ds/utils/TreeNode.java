package com.modest.ds.utils;

/**
 * description
 *
 * @author modest
 * @data 2019/07/26
 */
public class TreeNode {
    public int data;

    public TreeNode left;

    public TreeNode right;

    public TreeNode () {
    }

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int data, TreeNode left) {
        this.data = data;
        this.left = left;
        this.right = null;
    }

    public TreeNode(int data, TreeNode left,TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
