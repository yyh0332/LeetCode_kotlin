class No009 {
    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * 例如，121 是回文，而 123 不是。
     * 示例 1：
     * 输入：x = 121
     * 输出：true
     * 示例 2：
     * 输入：x = -121
     * 输出：false
     * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3：
     * 输入：x = 10
     * 输出：false
     * 解释：从右向左读, 为 01 。因此它不是一个回文数。
     */

    /*
    *暴力
    *执行耗时:276 ms,击败了7.73% 的Kotlin用户
	*内存消耗:34.4 MB,击败了48.97% 的Kotlin用户
    */
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        val num = "$x"
        for (index in 0 until num.length / 2) {
            //从第一位和倒数第一位开始比较
            if (num[index] != num[num.length - 1 - index]) return false
        }
        return true
    }

    /*
    * 比较最高位值和个位值
    *执行耗时:204 ms,击败了82.99% 的Kotlin用户
	*内存消耗:34.3 MB,击败了68.04% 的Kotlin用户
    */
    fun isPalindrome2(x: Int): Boolean {
        if (x < 0) return false
        var varx = x
        val num = "$x"
        var dev = 1
        val length = num.length
        for (index in 1 until length) {
            dev *= 10
        }
        for (index in length / 2 downTo 1) {
            //最高位数
            val left = varx / dev
            //个位数
            val right = varx % 10
            if (right != left) {
                return false
            }
            varx = (varx - dev * left - right) / 10
            dev /= 100
        }
        return true
    }

    /*
    * 反转整个数字并比较
    * 执行耗时:232 ms,击败了34.02% 的Kotlin用户
	* 内存消耗:34.4 MB,击败了52.58% 的Kotlin用户
    * */
    fun isPalindrome3(x: Int): Boolean {
        if (x < 0) return false
        var reverseNum = 0
        var num = x
        //反转整个数字
        while (num > 0) {
            reverseNum = reverseNum * 10 + num % 10
            num /= 10
        }
        return x == reverseNum
    }

    /*
    * 反转一半数字并比较
    * 执行耗时:220 ms,击败了51.55% 的Kotlin用户
	* 内存消耗:34.1 MB,击败了96.39% 的Kotlin用户
	*/
    fun isPalindrome4(x: Int): Boolean {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false
        var reverseNum = 0
        var num = x
        //反转一半数字
        while (num > reverseNum) {
            reverseNum = reverseNum * 10 + (num % 10)
            num /= 10
        }
        return reverseNum == num || reverseNum / 10 == num
    }
}

fun main() {
    var palindrome = No009().isPalindrome3(121)
    println(palindrome)
}

