package com.modest.ds;

import com.modest.ds.tree.BinarySearchTree;
import org.junit.Test;


/**
 * description
 *
 * @author modest
 * @date 2019/08/01
 */
public class BinarySearchTreeTest {

    @Test
    public  void test() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(7);
        bst.insert(4);
        bst.insert(2);
        bst.insert(9);
        bst.insert(0);
        bst.inOrder(bst.root);
        //删除2
        bst.erase(2);
        System.out.println("----------------------------------------------");
        bst.inOrder(bst.root);
        System.out.println("----------------------------------------------");
        //判断是否包含2
        System.out.println(bst.contain(2));
    }
}
