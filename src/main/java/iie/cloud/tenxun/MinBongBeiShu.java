package iie.cloud.tenxun;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/9/16.
 */
public class MinBongBeiShu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        beiShu(n);
    }

    public static void beiShu(int n) {
        int m = n+1;
        boolean flag[] = new boolean[n];
        for(int i = 0; i < n; i++) {
            flag[i] = false;
        }
        int sum = 0;
        boolean _find = false;
        while(true) {
//            System.out.println("########: " + m);
            for (int i = 0; i < n; i++) {
                if(!flag[i]) {
                    if(m % (i+1) == 0) {
                        flag[i] = true;
                        sum++;
                        if(sum == n) {
                            _find = true;
                            System.out.println(m);
                            break;
                        }
                    }
                }
            }
//            for(int j = 0; j < n; j++) {
//                System.out.print(flag[j] + " ");
//            }
//            System.out.println();
            if(_find) break;
            m++;
        }
    }
}
