package useJava;

/**
 * 袋子中装有一些物品，每个物品上都标记着数字 1 、0 或 -1 。
 * 给你四个非负整数 numOnes 、numZeros 、numNegOnes 和 k 。
 * 袋子最初包含：
 * numOnes 件标记为 1 的物品。
 * numZeroes 件标记为 0 的物品。
 * numNegOnes 件标记为 -1 的物品。
 * 现计划从这些物品中恰好选出 k 件物品。返回所有可行方案中，物品上所标记数字之和的最大值。
 * <p>
 * 示例 1：
 * 输入：numOnes = 3, numZeros = 2, numNegOnes = 0, k = 2
 * 输出：2
 * 解释：袋子中的物品分别标记为 {1, 1, 1, 0, 0} 。取 2 件标记为 1 的物品，得到的数字之和为 2 。
 * 可以证明 2 是所有可行方案中的最大值。
 */
public class No2600 {

    /**
     * 执行耗时:1 ms,击败了82.01% 的Java用户
     * 内存消耗:38.8 MB,击败了88.04% 的Java用户
     */
    public static int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k == 0) {
            return 0;
        }

        if (k <= numOnes) {
            return k;
        } else {
            //使用-1分的球数
            int useNegOnes = k - numOnes - numZeros;
            if (useNegOnes > 0) {
                return numOnes - useNegOnes;
            } else {
                return numOnes;
            }
        }
    }

    /**
     * 优化上面解法的情况细分
     * 执行耗时:1 ms,击败了82.01% 的Java用户
     * 内存消耗:38.8 MB,击败了75.98% 的Java用户
     */

    public static int kItemsWithMaximumSum2(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= numOnes) {
            return k;
        } else if (k <= numOnes + numZeros) {
            return numOnes;
        } else {
            return numOnes - (k - numOnes - numZeros);
        }
    }

    public static void main(String[] args) {
        int i = kItemsWithMaximumSum(3, 2, 0, 4);
        System.out.println(i);
    }
}
