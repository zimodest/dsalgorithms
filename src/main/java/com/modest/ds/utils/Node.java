package com.modest.ds.utils;

/**
 * description
 *
 * @author modest
 * @data 2019/07/26
 */
public class Node {
    public int data;

    public Node left;

    public Node right;

    public Node () {
    }

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Node(int data, Node left) {
        this.data = data;
        this.left = left;
        this.right = null;
    }

    public Node(int data, Node left,Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
