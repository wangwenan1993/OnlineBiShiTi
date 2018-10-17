package iie.cloud.lianjia2;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/9/3.
 * 假设有这样一个计算器，该计算器只有两个按钮，按下第一个按钮能使显示数值减少1，按下第二个按钮能使显示数值乘以2，当前显示数值为N，那么至少要按多少次按钮才能使显示数值变成M？

 输入
 输入两个整数N和M，1≤N，M≤109。

 输出
 输出使显示数值变成M的最少按按钮次数。
 */
public class ChangeN2M {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextInt();
        long m = in.nextInt();
        System.out.println(change(n, m));
    }

    public static long change(long n, long m) {
        if(n >= m) return n - m;
        else {
            long count = 0;
            while(n * 2 < m) {
                count++;
                n *= 2;
            }

            long tmp = m % 2 == 0 ? m/2 : m/2+1;
//            System.out.println(tmp);
            count += Math.min(n - tmp + 1 + tmp * 2 - m, n * 2 - m + 1);
            return count;
        }
    }
}
