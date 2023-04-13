class No0003 {

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     * 示例 1:
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
     * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
     * 提示：
     * 0 <= s.length <= 5 * 10⁴
     * s 由英文字母、数字、符号和空格组成
     */

    /*执行耗时:188 ms,击败了95.65% 的Kotlin用户
	内存消耗:34.3 MB,击败了99.13% 的Kotlin用户*/
    fun lengthOfLongestSubstring(s: String): Int {
        val length = s.length
        if (length == 0) {
            return 0;
        }
        var longest = 0
        var left = 0
        val map = HashMap<Char, Int>()
        for (i in 0 until length) {
            if (map.containsKey(s[i])) {
                left = Math.max(map[s[i]]!! + 1, left)
            }
            longest = Math.max(longest, i - left + 1)
            map[s[i]] = i;
        }
        return longest
    }

}

fun main() {
    val lengthOfLongestSubstring = No0003().lengthOfLongestSubstring("abbda")
    println(lengthOfLongestSubstring)
}