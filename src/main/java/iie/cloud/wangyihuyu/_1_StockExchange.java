package iie.cloud.wangyihuyu;

import java.util.Scanner;

/**
 * @author wangwenan
 * @date 2018/9/21 19:07
 */
public class _1_StockExchange {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] ss = in.nextLine().trim().split(" ");
        int arr[] = new int[ss.length];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(ss[i]);
        }
        maxProfit(arr);
    }

    public static void maxProfit(int[] prices) {
        int max_profit = Integer.MIN_VALUE;
        int min_price_index=0, begin=0, end=0;
        if(prices.length <= 0) System.out.println(max_profit + " " + begin + " " + end);
        int dp[] = new int[prices.length];
        int pre_min_price = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            if (prices[i] <= pre_min_price) {
                pre_min_price = prices[i];
                min_price_index = i;
            }
            pre_min_price = prices[i] < pre_min_price ? prices[i] : pre_min_price;
            dp[i] = prices[i] - pre_min_price;
            if(dp[i] > max_profit) {
                max_profit = dp[i];
                begin = min_price_index;
                end = i;
            } else if(dp[i] == max_profit && i - min_price_index < end - begin) {
                begin = min_price_index;
                end = i;
            }
        }
        System.out.println(max_profit + " " + (begin+1) + " " + (end+1));
    }
}


