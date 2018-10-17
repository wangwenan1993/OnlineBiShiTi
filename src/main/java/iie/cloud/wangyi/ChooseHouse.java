package iie.cloud.wangyi;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/9/8.
 */
public class ChooseHouse {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for(int i = 0; i < num; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            get_min_max(n, k);
        }
    }

    public static void get_min_max(int n, int k)
    {
        if(n<2||k<2||(n-k)<=1){
            System.out.println("0 0");
            return;
        }
        if(k==2){
            if(n==2){
                System.out.println("0 0");
                return;
            }else{
                System.out.println("0 1");
            }
        }
        int a1 = 0;
        int b1 = Math.min(k-1,n-k);
        System.out.println(a1 + " " + b1);
    }
}
