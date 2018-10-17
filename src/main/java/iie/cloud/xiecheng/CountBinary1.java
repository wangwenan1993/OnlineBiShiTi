package iie.cloud.xiecheng;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/9/4.
 */
public class CountBinary1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long x = in.nextLong();
        System.out.println(NumberOf1(x));
    }

    public static long NumberOf1(long n) {
        long count = 0, flag = 1;
        while(flag != 0) {
            if((flag & n) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
}
