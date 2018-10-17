package iie.cloud.xiaohongshu;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/9/15.
 */
public class Continue0 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n <= 0) System.out.println(0);
        else {
            int count = 0;
            for (int i = 1; i <= n; i++) {
                count += zeroCount(i);
            }
            System.out.println(count);
        }
    }

    static int zeroCount ( int n) {
        int counter = 0;
        while ( n >= 5) {
            n /= 5;
            counter += n;
        }
        return counter;
    }
}
