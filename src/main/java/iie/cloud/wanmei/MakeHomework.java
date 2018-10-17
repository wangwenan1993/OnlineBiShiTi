package iie.cloud.wanmei;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/8/28.
 */
public class MakeHomework {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int score[] = new int[num];
        int time[] = new int[num];
        for (int i = 0; i < num; i++) {
            score[i] = scanner.nextInt();
        }
        for (int i = 0; i < num; i++) {
            time[i] = scanner.nextInt();
        }
        int totalTime = scanner.nextInt();
        System.out.println(getScore(score, time, totalTime));
        System.out.println(getScore1(score, time, totalTime));
    }
    public static int getScore(int score[], int time[], int totalTime) {
        int[][] dp = new int[time.length][totalTime + 1];
        for (int j = 1; j < totalTime + 1; j++) {
            if (j >= time[0]) {
                dp[0][j] = score[0];
            } else {
                dp[0][j] = 0;
            }
            for (int i = 1; i < time.length; i++) {
                if (j < time[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - time[i]] + score[i], dp[i - 1][j]);
                }
            }
        }
        return dp[time.length - 1][totalTime];
    }

    public static int getScore1(int score[], int time[], int totalTime) {
        int[] dp = new int[totalTime + 1];
        for (int i = 0; i < time.length; i++) {
            for (int j = totalTime; j > 0; j--) {
                if (j >= time[i]) {
                    dp[j] = Math.max(dp[j - time[i]] + score[i], dp[j]);
                }
            }
        }
        return dp[totalTime];
    }
}
