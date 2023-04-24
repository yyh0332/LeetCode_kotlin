package useJava;

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
public class No0009 {
    /**
     * 暴力
     * 执行耗时:6 ms,击败了56.57% 的Java用户
     * 内存消耗:41.3 MB,击败了9.70% 的Java用户
     */
    public boolean isPalindrome(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        int length = chars.length;
        //特殊情况处理
        if (length == 1) {
            return true;
        } else if (x < 0) {
            return false;
        } else {
            //循环一半长度次数
            for (int i = 0; i < length / 2; i++) {
                //比较最高位和最低位
                if (chars[i] != chars[length - 1 - i]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 计算得到最高最低进行比较
     * 执行耗时:6 ms,击败了56.57% 的Java用户
     * 内存消耗:40.8 MB,击败了56.41% 的Java用户
     */
    public boolean isPalindrome2(int x) {
        //边界判断
        if (x < 0) return false;
        //得到计算位数
        int dev = 1;
        int length = String.valueOf(x).length();
        for (int y = 1; y < length; y++) {
            dev *= 10;
        }
        //循环一半的次数
        for (int i = length / 2; i > 0; i--) {
            //得到最高位数
            int left = x / dev;
            //得到个位数
            int right = x % 10;
            //不同为非回文之数
            if (left != right) {
                return false;
            }
            //得到去除最高位和个位之后的数
            x = (x - dev * left - right) / 10;
            //计算位数也减小两位
            dev /= 100;
        }
        return true;
    }

    /**
     * 将后半部分旋转
     * 执行耗时:5 ms,击败了97.96% 的Java用户
     * 内存消耗:40.8 MB,击败了50.09% 的Java用户
     */
    public boolean isPalindrome3(int x) {
        //特殊情况
        //如果数字的最后一位是 0，为了使该数字为回文，则其第一位数字也应该是 0,只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        //dev为后半部分值
        int dev = 0;
        while (x > dev) {
            dev = dev * 10 + x % 10;
            x /= 10;
        }
        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == dev || x == dev / 10;
    }

    public static void main(String[] args) {
        boolean palindrome = new No0009().isPalindrome3(10);
        System.out.println(palindrome);
    }
}
