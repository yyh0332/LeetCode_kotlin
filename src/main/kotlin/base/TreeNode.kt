package base

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun TreeNode.getString() {
    println(this.`val`)
    this.left?.getString()
    this.right?.getString()
}