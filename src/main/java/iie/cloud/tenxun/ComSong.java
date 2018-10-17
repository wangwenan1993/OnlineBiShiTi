package iie.cloud.tenxun;

import iie.cloud.util.PrintUtil;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/8/31.
 */
public class ComSong {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int song_len = in.nextInt();
        int a_len = in.nextInt();
        int a_count = in.nextInt();
        int b_len = in.nextInt();
        int b_count = in.nextInt();
        if(song_len < Math.min(a_len, b_len)) System.out.println(0);
        else {
            System.out.println(dp(song_len, a_len, a_count, b_len, b_count));
        }
    }

    public static int dp(int s_len, int a_len, int a_count, int b_len, int b_count) {
        int dp[] = new int[s_len+1];
        dp[0] = 1;
        int wei[] = new int[a_count+b_count];
        for(int i = 0; i < wei.length; i++) {
            if(i < a_count && a_len > 0) wei[i] = a_len;
            else wei[i] = b_len;
        }

        PrintUtil.printIntArray(wei);
        for(int i = 0; i < wei.length; i++) {
            for(int j = s_len; j >= 0; j--) {
                if(j >= wei[i]) {
                    dp[j] = dp[j] + dp[j-wei[i]];
                }
            }
        }
        return dp[s_len] % 1000000007;
    }
}
