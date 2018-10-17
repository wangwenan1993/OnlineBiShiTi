package iie.cloud.wangyi;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/9/8.
 */
public class LongestBlackWhite {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ss = in.nextLine().trim();
        if(ss.equals("")) System.out.println(0);
        else {
            char[] arr = ss.toCharArray();
            System.out.println(count(arr));
        }
    }

    public static int count(char[] arr) {
        int max_len = Integer.MIN_VALUE;
        int begin_len = Integer.MIN_VALUE;
        int begin_end = 0;
        int end_len = Integer.MIN_VALUE;
        char pre = arr[0];
        int len = 1;
        int begin = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != pre) {
//                System.out.println("$$$$$$$$$$$$$$$$$");
                len++;
                if(i == arr.length-1) {
                    end_len = len;
                }
            } else {
//                System.out.println("@@@@@@@@@@@@@@@@@");
                max_len = Math.max(max_len, len);
                if(begin == 0) {
                    begin_len = len;
                    begin_end = i-1;
                }
                if(i == arr.length-1) {
                    end_len = 1;
                }
                begin = i;
                len = 1;
            }
            pre = arr[i];
        }
        max_len = Math.max(max_len, len);

        if(begin_end != arr.length-1 && arr[0] != arr[arr.length-1]) {
            max_len = Math.max(max_len, begin_len + end_len);
        }
        return max_len;
    }
}
