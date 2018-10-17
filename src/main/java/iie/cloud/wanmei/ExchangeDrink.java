package iie.cloud.wanmei;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/8/28.
 */
public class ExchangeDrink {
    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);
        int x = reader.nextInt();
        int[] array = new int[x];
        for (int i = 0; i < x; i++) {
            array[i] = reader.nextInt();
        }
        int y = reader.nextInt();
        System.out.println(minCoins(array, y));
    }
    public static int minCoins(int[] arr, int aim) {
        if (arr == null || arr.length == 0) return -1;
        else if (aim <= 0) return 0;
        int [] dp = new int[aim + 1];
        //dp[0] = 1;
        for (int i = 1; i < aim + 1; i++) {
            int best = Integer.MAX_VALUE;
            for (int j = 0; j < arr.length; j++) {
                if (i >= arr[j]) {
                    best = Math.min(best, dp[i - arr[j]]);
                }
            }
            dp[i] = best == Integer.MAX_VALUE ? Integer.MAX_VALUE : best + 1;
        }
        return dp[aim] == Integer.MAX_VALUE? -1 : dp[aim];
    }
}
