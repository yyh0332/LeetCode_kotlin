package useJava;

import base.ListNode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class No002 {
    /*执行耗时:1 ms,击败了100.00% 的Java用户
    内存消耗:41.3 MB,击败了77.84% 的Java用户*/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //最终node
        ListNode listNodeJ = new ListNode(0);
        //工作节点
        ListNode cur = listNodeJ;
        //判断特殊情况
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        //进位
        int count = 0;
        while (l1 != null || l2 != null) {
            //取出节点值
            int var1 = l1 == null ? 0 : l1.getNum();
            int var2 = l2 == null ? 0 : l2.getNum();
            //计算当前节点值
            int sum = var1 + var2 + count;
            //计算进位
            count = sum / 10;
            //创建工作节点的下一个节点 且赋值
            cur.setNext(new ListNode(sum % 10));
            //将下节点赋值为当前工作节点
            cur = cur.getNext();
            //目标链表将下个节点赋值为当前作节点
            if (l1 != null) {
                l1 = l1.getNext();
            }
            if (l2 != null) {
                l2 = l2.getNext();
            }
        }
        //处理特殊情况：进位未使用完,即加到最后一个节点
        if (count == 1) {
            cur.setNext(new ListNode(1));
        }
        return listNodeJ.getNext();
    }

    public static void main(String[] args) {
        ListNode listNodeJ = new ListNode(9);
        listNodeJ.setNext(new ListNode(9));
        listNodeJ.getNext().setNext(new ListNode(9));
        listNodeJ.getNext().getNext().setNext(new ListNode(9));
        listNodeJ.getNext().getNext().getNext().setNext(new ListNode(9));
        listNodeJ.getNext().getNext().getNext().getNext().setNext(new ListNode(9));
        listNodeJ.getNext().getNext().getNext().getNext().getNext().setNext(new ListNode(9));

        ListNode listNodeJ1 = new ListNode(9);
        listNodeJ1.setNext(new ListNode(9));
        listNodeJ1.getNext().setNext(new ListNode(9));
        listNodeJ1.getNext().getNext().setNext(new ListNode(9));
//        listNodeJ1.getNext().setNext(new ListNode(4));

        ListNode listNodeJ2 = new No002().addTwoNumbers(listNodeJ, listNodeJ1);
        System.out.println(listNodeJ2);
    }
}
