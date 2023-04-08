class No0001 {
    //给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
//
// 你可以按任意顺序返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//
//
// 示例 2：
//
//
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
//
//
// 示例 3：
//
//
//输入：nums = [3,3], target = 6
//输出：[0,1]
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val hashMap = HashMap<Int, Int>()
        //遍历目标数组
        for (index in nums.withIndex()) {
            //当前数字需要的数字
            val i = target - index.value
            if (hashMap.contains(i)) {
                //存在当前下标数字所有需要的数字 即符合要求 返回那个需要数字的原始数字的下标 和当前下标
                return intArrayOf(hashMap[i]!!, index.index)
            } else {
                //如果不存在 当前下标数字对应需要的数字 就存需要的数字和当前下标
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