package com.modest.ds.tree;

import com.modest.ds.utils.Node;


/**
 * 二叉搜索树
 *
 * 注意：树的节点的左右节点的访问权限不能设置成private，不能通过getter/setter方法获取
 *
 * 概念：或者是一棵空树，或者具有以下性质
 *
 * 若左子树不为空，则左子树上所有节点的值都小于根节点的值
 * 若右子树不为空，则右子树上所有节点的值都大于根节点的值
 *它的左右子树也为二叉搜索树
 *
 * @author modest
 * @data 2019/07/26
 */
public class BinarySearchTree {

    public Node root;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public BinarySearchTree() {
    }
    /**
     * 向二叉搜索树中插入元素
     **
     * @param data
     * @return
     */
    public boolean insert(int data) {
        Node node = new Node(data);

        //若树为空，直接插入
        if(this.root == null){
            this.root = node;
            this.size++;
            return true;
        }

        //用于遍历的指针
        Node cur = this.root;

        //用于记录根节点的指针
        Node parent = cur;

        //用于循环的指针不为空时，进入循环
        while(cur != null) {
            //记录当前的根节点
            parent = cur;

            //要插入的值小于根节点的值
            if(data < cur.data ){
                cur = cur.left;
            }
            //要插入的值大于根节点的值
            else if(data> cur.data){
                cur = cur.right;
            }
            //要插入的值等于根节点的值
            else {
                return true;
            }
        }

        //记录当前根节点的指针的左子树或右子树为空

        //若要插入的数据小于当前记录的根节点的值，将新节点插入当前记录的根节点的左子树
        if(data<parent.data) {
            parent.left = node;
            this.size++;
        }
        //若要插入的数据大于当前记录的根节点的值，将新节点插入当前记录的根节点的右子树
        else{
            parent.right = node;
            this.size++;
        }
        return true;
    }

    /**
     *
     * 删除二叉搜索树的节点
     *
     * @return
     */
    public boolean erase(int date) {
        if(this.root == null) {
            return false;
        }

        Node cur = this.root;
        Node parent = null;

        while (cur != null) {
            if(cur.data == date ){
                break;
            }else if(date<cur.data) {
                parent = cur;
                cur = cur.left;
            }else {
                parent = cur;
                cur = cur.right;
            }
        }
        if(cur == null) {
            return false;
        }

        //左孩子为空
        if(cur.left == null) {

            if(this.root == cur) {
                this.root = cur.right;
            } else {
                if(cur == parent.left) {
                    parent.left = cur.right;
                }else {
                    parent.right = cur.right;
                }
            }
        } else  if(cur.right == null) {
            if(cur == this.root) {
                this.root = cur.left;
            } else {
                if(cur == parent.left) {
                    parent.left = cur.left;
                }else {
                    parent.right = cur.left;
                }
            }
        } else {
            //左右孩子均存在，不能直接删除，找一个替代节点
            //可以在左子树中找：左子树中最右侧节点
            //也可以在右子树中找：右子树中最左侧节点

            //右子树
            Node pFirstOfIn = cur.right;
            Node pParent = cur;


            while (pFirstOfIn.left != null) {
                pParent = pFirstOfIn;
                pFirstOfIn = pFirstOfIn.left;
            }
            //找到右子树的最左侧节点，替代节点，一定没有左孩子，可能有右子树
            cur.data = pFirstOfIn.data;

            pParent.left = pFirstOfIn.right;

        }
        return true;
    }

    public boolean contain(int data) {

        if(this.root == null) {
            return false;
        }

        Node cur = this.root;
        while (cur != null) {
            if(cur.data == data) {
                return true;
            }

            if(data < this.root.data) {
                cur = cur.left;
            }else {
                cur = cur.right;
            }
        }
        return false;
    }





    /**
     *中序遍历二叉搜索树
     *
     * @param root  根节点
     */
    public void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

}


