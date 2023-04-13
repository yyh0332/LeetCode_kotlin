package useJava;

import java.util.HashMap;

/**
 * /**
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
public class No003 {
    /*执行耗时:4 ms,击败了86.42% 的Java用户
     * 内存消耗:41.5 MB,击败了72.98% 的Java用户*/
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        //处理特殊情况
        if (length == 0) {
            return 0;
        }
        //最长长度
        int longest = 0;
        //左指针
        int left = 0;
        //记录每个不同字符出现的最后位置
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int end = 0; end < length; end++) {
            char ch = s.charAt(end);
            if (hashMap.containsKey(ch)) {
                //如果这个字符已经出现过，代表当中子串包含了重复数字
                //需要从当中字符的后一位开始，即左指针需要指到当中字符的后一位
                //去max(hashMap.get(ch) + 1, left) 存在其它在较前面的字符，只+1的话就可能导致左指针不是当中当前字符的后一位
                left = Math.max(hashMap.get(ch) + 1, left);
            }
            //计算当前子串的长度和最大长度
            longest = Math.max(longest, end - left + 1);
            //存储当前字符的位置
            hashMap.put(ch, end);
        }
        return longest;
    }

    public static void main(String[] args) {
        int length = new No003().lengthOfLongestSubstring("abba");
        System.out.println(length);
    }
}
