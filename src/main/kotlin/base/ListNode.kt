package base

class ListNode(var num: Int) {
    var next: ListNode? = null

}

//到最后会有NullPointerException
fun ListNode.getString(): Unit {
    var innode = this;
    while (innode != null) {
        println(innode.num)
        innode = innode.next!!
    }
}