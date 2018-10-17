package iie.cloud.zhaoshang;

import iie.cloud.util.PrintUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class SubArr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum  = in.nextInt();
        dp(sum);
    }

    public static void dp(int sum) {
        int[] arr = new int[sum];
        for(int i = 1; i <= sum; i++) {
            arr[i-1] = i;
        }
//        PrintUtil.printIntArray(arr);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int _sum = 0;
        for(int i = 0; i < arr.length; i++) {
            _sum += arr[i];
            if(map.containsKey(_sum - sum)) {
                printList(map.get(_sum-sum)+1, i+1);
            } else {
                map.put(_sum, i+1);
            }
        }
    }

    public static void printList(int begin, int end) {
        System.out.print("[");
        for(int i = begin; i <= end; i++) {
            if(i < end) {
                System.out.print(i + ", ");
            } else {
                System.out.print(i);
            }
        }
        System.out.print("] ");
    }
}