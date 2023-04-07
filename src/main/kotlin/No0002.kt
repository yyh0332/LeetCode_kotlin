import base.ListNode
import base.getString

class No0002 {
    /**
    给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
    请你将两个数相加，并以相同形式返回一个表示和的链表。
    你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

    示例 1：
    输入：l1 = [2,4,3], l2 = [5,6,4]
    输出：[7,0,8]
    解释：342 + 465 = 807.

    示例 2：
    输入：l1 = [0], l2 = [0]
    输出：[0]

    示例 3

    输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    输出：[8,9,9,9,0,0,0,1]

    提示：

    每个链表中的节点数在范围 [1, 100] 内
    0 <= Node.val <= 9
    题目数据保证列表表示的数字不含前导零
     */

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        //最终node
        val node = ListNode(0)
        var innode = node
        //处理特殊情况
        if (l1 == null && l2 == null) return null
        if (l1 == null) return l2
        if (l2 == null) return l1
        //进位数
        var count = 0
        var node1 = l1
        var node2 = l2
        while (node1 != null || node2 != null) {
            val nums = (node1?.num ?: 0) + (node2?.num ?: 0) + count
            count = nums / 10
            innode.next = ListNode(nums % 10)
            innode = innode.next!!
            node1 = node1?.next
            node2 = node2?.next
        }
        if (count != 0) {
            innode.next = ListNode(1)
        }
        return node.next
    }
}

fun main() {
    val listNode = ListNode(2)
    val listNode1 = ListNode(4)
    val listNode2 = ListNode(3)
    listNode.next = listNode1
    listNode.next?.next = listNode2

    val listNode3 = ListNode(5)
    val listNode4 = ListNode(6)
    val listNode5 = ListNode(4)
    listNode3.next = listNode4
    listNode3.next?.next = listNode5
    val addTwoNumbers = No0002().addTwoNumbers(listNode, listNode3)
    println(addTwoNumbers?.getString())
}