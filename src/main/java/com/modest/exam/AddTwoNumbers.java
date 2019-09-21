package com.modest.exam;

class ListNode{
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author modest
 * @date 2019/09/20
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null && l2 == null) {
            return null;
        }

        ListNode node = new ListNode(0);
        ListNode temp = node;

        while(l1 != null || l2 != null) {
            int a = 0;
            if(l1 != null) {
                a += l1.val;
            }
            if(l2 != null) {
                a += l2.val;
            }


            a += temp.val;
            temp.val = a % 10;

            if( (l1 != null && l1.next != null) || (l2 != null && l2.next != null) || a >= 10) {
                temp.next = new ListNode(a / 10);
            }

            if(l1 != null) {
                l1 = l1.next;
            }

            if(l2 != null) {
                l2 = l2.next;
            }
            temp = temp.next;
        }
        return node;
    }

}
