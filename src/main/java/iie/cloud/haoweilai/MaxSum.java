package iie.cloud.haoweilai;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/8/28.
 */
public class MaxSum {
    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        while(i++ < n) {
            list.add(reader.nextInt());
        }
        System.out.println(maxSum(list));
    }

    public static long maxSum(ArrayList<Integer> array) {
        if (array.size() <= 0) return 0;
        int[] sum = new int[array.size()];
        sum[0] = array.get(0);
        int maxMum = sum[0];
        for(int i = 1; i < array.size(); i++) {
            int tmp = i;
            while(tmp > 0 && array.get(i) <= array.get(tmp-1)) tmp--;
            sum[i] = tmp == -1 ? array.get(i) : sum[tmp] + array.get(i);
            maxMum = maxMum < sum[i]? sum[i] : maxMum;
        }
        for(int i = 0; i < sum.length; i++) {
            System.out.print(sum[i] + " ");
        }
        System.out.println();
        return maxMum;
    }
}
