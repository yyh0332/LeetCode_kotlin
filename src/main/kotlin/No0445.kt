import base.ListNode
import java.util.*

class No0445 {
    //给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
    // 你可以假设除了数字 0 之外，这两个数字都不会以零开头。

    //输入：l1 = [7,2,4,3], l2 = [5,6,4]
    //输出：[7,8,0,7]

    // 输入数据保证链表代表的数字无前导 0
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1?.num == 0) {
            return l2
        }
        if (l2?.num == 0) {
            return l1
        }
        var l11 = l1
        var l22 = l2
        var carry = 0
        //反转链表
        val stack1 = Stack<Int>()
        val stack2 = Stack<Int>()
        val stack3 = Stack<Int>()
        while (l11 != null) {
            stack1.push(l11.num)
            l11 = l11.next
        }
        while (l22 != null) {
            stack2.push(l22.num)
            l22 = l22.next
        }
        while (!stack1.isEmpty() || !stack2.empty()) {
            val pop1 = if (stack1.isEmpty()) 0 else stack1.pop()
            val pop2 = if (stack2.isEmpty()) 0 else stack2.pop()
            val i: Int = pop1 + pop2 + carry
            val i1 = i % 10
            carry = i / 10
            stack3.push(i1)
        }
        if (carry != 0) {
            stack3.push(carry)
        }
        //处理链表
        //处理链表
        val node = ListNode(stack3.pop())
        var wNode: ListNode? = node
        while (!stack3.empty()) {
            wNode!!.next = ListNode(stack3.pop())
            wNode = wNode.next
        }
        return node
    }
}

fun main() {
    val addTwoNumbers = No0445().addTwoNumbers(ListNode.getSampleListNode()[0], ListNode.getSampleListNode()[1])
    println(addTwoNumbers?.getString())
}