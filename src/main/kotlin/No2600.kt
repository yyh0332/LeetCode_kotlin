class No2600 {

    /*
    * 执行耗时:156 ms,击败了46.67% 的Kotlin用户
	内存消耗:32.8 MB,击败了100.00% 的Kotlin用户*/
    fun kItemsWithMaximumSum(numOnes: Int, numZeros: Int, numNegOnes: Int, k: Int): Int {
        if (k == 0) {
            return 0
        }
        return if (k <= numOnes) {
            k
        } else {
            val useNegOnes = k - numOnes - numZeros
            if (useNegOnes > 0) {
                numOnes - useNegOnes;
            } else {
                numOnes;
            }
        }
    }
}

fun main() {
    val kItemsWithMaximumSum = No2600().kItemsWithMaximumSum(3, 2, 0, 4)
    println(kItemsWithMaximumSum)
}