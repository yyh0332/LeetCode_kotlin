package useJava;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */
class No0001 {

    /**
     * 执行耗时:58 ms,击败了14.33% 的Java用户
     * 内存消耗:41.7 MB,击败了40.31% 的Java用户
     */
    public int[] twoSum(int[] nums, int target) {
        //简单双指针 判断想加是否相等
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0};
    }


    /**
     * 执行耗时:1 ms,击败了98.77% 的Java用户
     * 内存消耗:41.9 MB,击败了14.21% 的Java用户
     */
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                //存在当前下标数字所有需要的数字 即符合要求 返回那个需要数字的原始数字的下标 和当前下标
                return new int[]{map.get(nums[i]), i};
            } else {
                //如果不存在 当前下标数字对应需要的数字 就存需要的数字和当前下标
                map.put(target - nums[i], i);
            }
        }
        return new int[]{0};
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 5, 5, 11};
        int[] ints = new No0001().twoSum2(a, 10);
        for (int i : ints) {
            System.out.println(i);
        }
    }
}

