package useJava;

/**
 * Alice 和 Bob 计划分别去罗马开会。
 * 给你四个字符串 arriveAlice ，leaveAlice ，arriveBob 和 leaveBob 。Alice 会在日期 arriveAlice 到
 * leaveAlice 之间在城市里（日期为闭区间），而 Bob 在日期 arriveBob 到 leaveBob 之间在城市里（日期为闭区间）。每个字符串都包
 * 含 5 个字符，格式为 "MM-DD" ，对应着一个日期的月和日。
 * 请你返回 Alice和 Bob 同时在罗马的天数。
 * 你可以假设所有日期都在 同一个 自然年，而且 不是 闰年。每个月份的天数分别为：[31, 28, 31, 30, 31, 30, 31, 31, 30, 31
 * , 30, 31] 。
 * 示例 1：
 * 输入：arriveAlice = "08-15", leaveAlice = "08-18", arriveBob = "08-16", leaveBob =
 * "08-19"
 * 输出：3
 * 解释：Alice 从 8 月 15 号到 8 月 18 号在罗马。Bob 从 8 月 16 号到 8 月 19 号在罗马，他们同时在罗马的日期为 8 月 16、
 * 17 和 18 号。所以答案为 3 。
 * 示例 2：
 * 输入：arriveAlice = "10-01", leaveAlice = "10-31", arriveBob = "11-01", leaveBob =
 * "12-31"
 * 输出：0
 * 解释：Alice 和 Bob 没有同时在罗马的日子，所以我们返回 0 。
 * 提示：
 * 所有日期的格式均为 "MM-DD" 。
 * Alice 和 Bob 的到达日期都 早于或等于 他们的离开日期。
 * 题目测试用例所给出的日期均为 非闰年 的有效日期。
 */
public class No2409 {
    /**
     * 模拟
     * 执行耗时:1 ms,击败了54.39% 的Java用户
     * 内存消耗:39.8 MB,击败了18.71% 的Java用户
     */
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] dayMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //月份的天数
        for (int i = 1; i < dayMonth.length; i++) {
            dayMonth[i] = dayMonth[i] + dayMonth[i - 1];
        }
        //得到天数 一年中的多少天
        int aA = dayMonth[Integer.parseInt(arriveAlice.split("-")[0]) - 1] + Integer.parseInt(arriveAlice.split("-")[1]);
        int aL = dayMonth[Integer.parseInt(leaveAlice.split("-")[0]) - 1] + Integer.parseInt(leaveAlice.split("-")[1]);
        int bA = dayMonth[Integer.parseInt(arriveBob.split("-")[0]) - 1] + Integer.parseInt(arriveBob.split("-")[1]);
        int bL = dayMonth[Integer.parseInt(leaveBob.split("-")[0]) - 1] + Integer.parseInt(leaveBob.split("-")[1]);
        int days = Math.min(bL, aL) - Math.max(aA, bA);
        if (days < 0) {
            //特殊情况处理 不同时在
            return 0;
        } else if (days == 0) {
            //同一天
            return 1;
        } else {
            return days + 1;
        }
    }

    public static void main(String[] args) {
        int i = new No2409().countDaysTogether("08-15", "08-18", "08-16", "08-16");
        System.out.println(i);
    }
}
