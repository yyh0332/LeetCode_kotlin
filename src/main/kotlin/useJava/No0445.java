package useJava;

import base.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 */
public class No0445 {

    /* 龟速解法
    执行耗时:8 ms,击败了9.28% 的Java用户
    内存消耗:42.5 MB,击败了30.56% 的Java用户*/
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.getNum() == 0) {
            return l2;
        }
        if (l2.getNum() == 0) {
            return l1;
        }

        //反转链表
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.getNum());
            l1 = l1.getNext();
        }
        while (l2 != null) {
            stack2.push(l2.getNum());
            l2 = l2.getNext();
        }
        int carry = 0;
        //链表相加
        while (!stack1.empty() || !stack2.empty()) {
            int pop1 = stack1.isEmpty() ? 0 : stack1.pop();
            int pop2 = stack2.isEmpty() ? 0 : stack2.pop();
            int i = pop1 + pop2 + carry;
            int i1 = i % 10;
            carry = i / 10;
            stack3.push(i1);
        }
        if (carry != 0) {
            stack3.push(carry);
        }
        //处理链表
        ListNode node = new ListNode(stack3.pop());
        ListNode wNode = node;
        while (!stack3.empty()) {
            wNode.setNext(new ListNode(stack3.pop()));
            wNode = wNode.getNext();
        }
        return node;
    }

    public static void main(String[] args) {
        List<ListNode> sampleListNode = ListNode.Companion.getSampleListNode();
        ListNode listNode = addTwoNumbers(sampleListNode.get(0), sampleListNode.get(1));
        listNode.getString();
    }
}
