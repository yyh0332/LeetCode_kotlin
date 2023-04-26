package base

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    companion object {
        fun getSampleTree(): TreeNode {
            val treeNode = TreeNode(11)
            val treeNode2 = TreeNode(22)
            val treeNode3 = TreeNode(33)
            val treeNode4 = TreeNode(44)
            val treeNode5 = TreeNode(55)
            treeNode.left = treeNode2
            treeNode.right = treeNode3
            treeNode2.right = treeNode4
            treeNode3.left = treeNode5
            return treeNode
        }
    }

    fun getString() {
        println(this.`val`)
        this.left?.getString()
        this.right?.getString()
    }
}



