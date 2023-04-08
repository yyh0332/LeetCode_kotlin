package base

class ListNode(var num: Int) {
    var next: ListNode? = null

}

fun ListNode.getString(): Unit {
    var innode = this;
    while (innode.next != null) {
        println(innode.num)
        innode = innode.next!!
    }
    //增加最后一个节点
    println(innode.num)
}