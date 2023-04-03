class No0001 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val hashMap = HashMap<Int, Int>()
        for (index in nums.withIndex()) {
            val i = target - index.value
            if (hashMap.contains(i)) {
                return intArrayOf(hashMap[i]!!, index.index)
            } else {
                hashMap[index.value] = index.index
            }
        }
        return intArrayOf(0)
    }
}

fun main() {
    val intArrayOf = intArrayOf(2, 7, 11, 15)
    val twoSum = No0001().twoSum(intArrayOf, 9)
    for (i in twoSum) {
        println(i)
    }
}