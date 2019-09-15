package com.modest.ds.utils;


/**
 * description
 *
 * @author modest
 * @date 2019/09/13
 */
public class TreeUtils {


}



/**
 * description
 *
 * @author modest
 * @data 2019/07/26
 */
//class Node {
//    public char data;
//
//    public Node left;
//
//    public Node right;
//
//    public Node () {
//    }
//
//    public Node(char data) {
//        this.data = data;
//        this.left = null;
//        this.right = null;
//    }
//
//    public Node(char data, Node left) {
//        this.data = data;
//        this.left = left;
//        this.right = null;
//    }
//
//    public Node(char data, Node left,Node right) {
//        this.data = data;
//        this.left = left;
//        this.right = right;
//    }
//}
//
//
//public class Main{
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String str = in.nextLine();
//        char[] inOrders = str.toCharArray();
//        str = in.nextLine();
//        char[] postOrders = str.toCharArray();
//        Node root = createTree(inOrders,postOrders);
//        preOrder(root);
//    }
//
//    public static Node createTree(char[] inOrders, char[] postOrders) {
//
//        if(inOrders==null || postOrders== null || inOrders.length==0 || postOrders.length == 0) {
//            return null;
//        }
//
//        Node root = new Node(postOrders[postOrders.length-1]);
//        int i=0;
//        for(;i<inOrders.length; i++) {
//            if(postOrders[postOrders.length-1] == inOrders[i]) {
//                break;
//            }
//        }
//
//        char[] leftIn = Arrays.copyOfRange(inOrders,0,i);
//        char[] leftPost = Arrays.copyOfRange(postOrders,0,i);
//
//        char[] rightIn = Arrays.copyOfRange(inOrders,i+1,inOrders.length);
//        char[] rightPost = Arrays.copyOfRange(postOrders,i, postOrders.length-1);
//
//        root.left = createTree(leftIn,leftPost);
//        root.right = createTree(rightIn, rightPost);
//        return root;
//    }
//
//
//    public static void preOrder(Node root) {
//        if(root == null) {
//            return;
//        }
//
//        System.out.print(root.data);
//        preOrder(root.left);
//        preOrder(root.right);
//    }
//}