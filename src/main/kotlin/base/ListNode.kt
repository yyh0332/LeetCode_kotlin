package base

class ListNode(var num: Int) {
    var next: ListNode? = null

    fun getString() {
        var innode = this;
        while (innode.next != null) {
            println(innode.num)
            innode = innode.next!!
        }
        //增加最后一个节点
        println(innode.num)
    }

    companion object {
        fun getSampleListNode(): List<ListNode> {
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

            return listOf(listNode, listNode3)
        }
    }

}


