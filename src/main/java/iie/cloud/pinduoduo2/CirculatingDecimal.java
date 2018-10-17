package iie.cloud.pinduoduo2;

import java.util.Scanner;
import java.util.Vector;

/**
 * Created by Administrator on 2018/8/30.
 * 给定被除数和除数，求出循环小数的开始位置和循环长度
 * 若没有循环小数则开始位置为结束位置，长度为0
 */
public class CirculatingDecimal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ss(n, m);
    }

    public static void ss(int n, int m) {
        if(m == 0) {
            System.out.println(0 + " " + 0);
            return;
        }
        n = n % m;
        Vector v = new Vector();

        for (;;) {
            v.add(n);
            n *= 10;
            n = n % m;
            if (n == 0) {
                System.out.println(v.size() + " " + 0);
                return;
            }

            if (v.indexOf(n) >= 0) {
                int res = v.size() - v.indexOf(n);
                System.out.println(v.indexOf(n) + " " + res);
                return;
            }
        }
    }
}
