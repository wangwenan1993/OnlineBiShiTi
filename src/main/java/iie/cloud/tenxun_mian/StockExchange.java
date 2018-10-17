package iie.cloud.tenxun_mian;

/**
 * @Author wangwenan
 * @data 2018/8/28 9:11
 */
public class StockExchange {

    public static void main(String[] args) {
//        int[] prices = {7,1,5,3,6,4};
//        int[] prices = {3,3,5,0,0,3,1,4};
        int[] prices = {1, 7, 2, 4};
        System.out.println(exchangeOnce(prices));
        System.out.println(exchangeAnyTimes(prices));
        System.out.println(exchangeAtMostTwice(prices));
        System.out.println(exchangeAtMostKTimes(2, prices));
        System.out.println(exchangeAnyTimesWithCooldown(prices));
    }

    /**
     * 第一种：仅交易一次（买一次卖一次）
     * @param prices
     * @return
     */
    public static int exchangeOnce(int[] prices) {
        int max_profit = 0;
        if(prices.length <= 0) return max_profit;
        int dp[] = new int[prices.length];
        int pre_min_price = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            pre_min_price = prices[i] < pre_min_price ? prices[i] : pre_min_price;
            dp[i] = prices[i] - pre_min_price;
            max_profit = dp[i] > max_profit ? dp[i] : max_profit;
        }
        return max_profit;
    }

    /**
     * 第二种：可交易多次
     * @param prices
     * @return
     */
    public static int exchangeAnyTimes(int[] prices) {
        int max_profit = 0;
        if(prices.length <= 0) return max_profit;
        for(int i = 1; i < prices.length; i++) {
            max_profit += prices[i] > prices[i-1] ? prices[i] - prices[i-1] : 0;
        }
        return max_profit;
    }

    /**
     * 第三种：可交易至多两次
     *  Time complexity is O(kn), space complexity can be O(n) because this DP only uses the result from last step.
     *  But for cleaness this solution still used O(kn) space complexity to preserve similarity to the equations in the comments.
     *  dp[k, ii] represents the max profit up until prices[ii] (Note: NOT ending with prices[ii]) using at most k transactions.
     *  dp[k, ii] = max(dp[k, ii-1], prices[ii] - prices[jj] + dp[k-1, jj]) { jj in range of [0, ii-1] }
     *            = max(dp[k, ii-1], prices[ii] + max(dp[k-1, jj] - prices[jj]))
     *  dp[0, ii] = 0; 0 times transation makes 0 profit
     *  dp[k, 0] = 0; if there is only one price data point you can't make any money no matter how many times you can trade
     * @param prices
     * @return
     */
    public static int exchangeAtMostTwice(int[] prices) {
        int max_profit = 0;
        if(prices.length <= 0) return max_profit;
        final int K = 2; // 最大可交易次数
        int[][] dp = new int[K+1][prices.length];
        for(int kk = 1; kk <= K; kk++) {
            int tmpMax = dp[kk-1][0] - prices[0];
            for (int ii = 1; ii < prices.length; ii++) {
                dp[kk][ii] = Math.max(dp[kk][ii-1], prices[ii] + tmpMax);
                tmpMax = Math.max(tmpMax, dp[kk-1][ii] - prices[ii]);
                max_profit = Math.max(max_profit, dp[kk][ii]);
            }
        }
        return max_profit;
    }


    /**
     * 第四种：可交易至多K次
     *  Time complexity is O(kn), space complexity can be O(n) because this DP only uses the result from last step.
     *  But for cleaness this solution still used O(kn) space complexity to preserve similarity to the equations in the comments.
     *  dp[k, ii] represents the max profit up until prices[ii] (Note: NOT ending with prices[ii]) using at most k transactions.
     *  dp[k, ii] = max(dp[k, ii-1], prices[ii] - prices[jj] + dp[k-1, jj]) { jj in range of [0, ii-1] }
     *            = max(dp[k, ii-1], prices[ii] + max(dp[k-1, jj] - prices[jj]))
     *  dp[0, ii] = 0; 0 times transation makes 0 profit
     *  dp[k, 0] = 0; if there is only one price data point you can't make any money no matter how many times you can trade
     * @param prices
     * @return
     */
    public static int exchangeAtMostKTimes(int k, int[] prices) {
        int max_profit = 0;
        if(prices.length <= 0) return max_profit;
        if(k > prices.length / 2) return quickSolve(prices);   // 处理k特别大时出现TLD
        int[] dp_kk_1_trans = new int[prices.length];   // 存储只交易kk-1次时的收益，防止出现MLD
        for(int kk = 1; kk <= k; kk++) {
            int tmpMax = dp_kk_1_trans[0] - prices[0];
            for (int ii = 1; ii < prices.length; ii++) {
                int curr = Math.max(dp_kk_1_trans[ii-1], prices[ii] + tmpMax);
                tmpMax = Math.max(tmpMax, dp_kk_1_trans[ii] - prices[ii]);
                dp_kk_1_trans[ii] = curr;
                max_profit = Math.max(max_profit, dp_kk_1_trans[ii]);
            }
        }
        return max_profit;
    }

    public static int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }


    /**
     * 第五种：可交易任意多次，但每次卖出之后需要休息至少一天才能再次买入
     * 该方法只能通过95%的测试用例
     * Input:
        [8,6,4,3,3,2,3,5,8,3,8,2,6]
       Output:
        8
       Expected:
        10
     * @param prices
     * @return
     */
    public static int exchangeAnyTimesWithCooldown(int[] prices) {
        int max_profit = 0;
        if(prices.length <= 0) return max_profit;
        int pre_sell = Integer.MIN_VALUE;    // 存储上一轮卖出是时间
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]) {
                if(i-2 >= 0 && pre_sell == i-2) {  // 上一轮卖出的时间是否刚好是本轮买入的前一天，这是需要对上一轮的卖出时间回退或者放弃本轮买入
                    System.out.println("$$$$$$$$$$$: " + i + " " + max_profit);
                    if(prices[i]-prices[i-1] > prices[i-2]-prices[i-3]) {   // 本轮买入的收益大于上轮最后一天的收益，对上一轮回退一天
                        max_profit -= (prices[i-2]-prices[i-3]);
                        if(prices[i-1] > prices[i-3]) max_profit += prices[i-1] - prices[i-3];
                        pre_sell--;
                        i--;
                    }
                    System.out.println("$$$$$$$$$$$: " + i + " " + max_profit);
                    continue;
                }

                max_profit += prices[i] - prices[i-1];

                if(i+1 < prices.length && prices[i+1] < prices[i]) {  // 如果当前值是一个波峰则更新pre_sell的值
                    pre_sell = i;
                }
            }
        }
        return max_profit;
    }

    /**
     * The natural states for this problem is the 3 possible transactions : buy, sell, rest. Here rest means no transaction on that day (aka cooldown).

     Then the transaction sequences can end with any of these three states.

     For each of them we make an array, buy[n], sell[n] and rest[n].

     buy[i] means before day i what is the maxProfit for any sequence end with buy.

     sell[i] means before day i what is the maxProfit for any sequence end with sell.

     rest[i] means before day i what is the maxProfit for any sequence end with rest.

     Then we want to deduce the transition functions for buy sell and rest. By definition we have:

     buy[i]  = max(rest[i-1]-price, buy[i-1])
     sell[i] = max(buy[i-1]+price, sell[i-1])
     rest[i] = max(sell[i-1], buy[i-1], rest[i-1])
     Where price is the price of day i. All of these are very straightforward. They simply represents :

     (1) We have to `rest` before we `buy` and
     (2) we have to `buy` before we `sell`
     One tricky point is how do you make sure you sell before you buy, since from the equations it seems that [buy, rest, buy] is entirely possible.

     Well, the answer lies within the fact that buy[i] <= rest[i] which means rest[i] = max(sell[i-1], rest[i-1]). That made sure [buy, rest, buy] is never occurred.

     A further observation is that and rest[i] <= sell[i] is also true therefore

     rest[i] = sell[i-1]
     Substitute this in to buy[i] we now have 2 functions instead of 3:

     buy[i] = max(sell[i-2]-price, buy[i-1])
     sell[i] = max(buy[i-1]+price, sell[i-1])
     This is better than 3, but

     we can do even better

     Since states of day i relies only on i-1 and i-2 we can reduce the O(n) space to O(1). And here we are at our final solution:
     * @param prices
     * @return
     */
    public int exchangeAnyTimesWithCooldown1(int[] prices) {
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }

    /**
     * 第六种：可交易任意多次，但每次交易都有费用
     * This problem is just like the other stock problems.
     At given day, we can do 1 out of 4 things:

     buy stock
     hold stock
     do nothing with empty portfolio
     sell stock
     We have 4 arrays with the length of # of the days, recording the max profit at given day if we do given operation.
     * @param prices
     * @return
     */
    public int exchangeAnyTimesWithFee(int fee, int[] prices) {
        if(prices.length <= 1) return 0;
        int[] buy = new int[prices.length];
        int[] hold = new int[prices.length];
        int[] skip = new int[prices.length];
        int[] sell = new int[prices.length];
        // the moment we buy a stock, our balance should decrease
        buy[0] = 0 - prices[0];
        // assume if we have stock in the first day, we are still in deficit
        hold[0] = 0 - prices[0];
        for(int i = 1; i < prices.length; i++){
            // We can only buy on today if we sold stock
            // or skipped with empty portfolio yesterday
            buy[i] = Math.max(skip[i-1], sell[i-1]) - prices[i];
            // Can only hold if we bought or already holding stock yesterday
            hold[i] = Math.max(buy[i-1], hold[i-1]);
            // Can skip only if we skipped, or sold stock yesterday
            skip[i] = Math.max(skip[i-1], sell[i-1]);
            // Can sell only if we bought, or held stock yesterday
            sell[i] = Math.max(buy[i-1], hold[i-1]) + prices[i] - fee;
        }
        // Get the max of all the 4 actions on the last day.
        int max = Math.max(buy[prices.length - 1], hold[prices.length - 1]);
        max = Math.max(skip[prices.length - 1], max);
        max = Math.max(sell[prices.length - 1], max);
        return Math.max(max, 0);
    }
}
