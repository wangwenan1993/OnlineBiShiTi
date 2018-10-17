package iie.cloud.zhihu;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/9/1.
 * 给定一个非递减序列，里面有很多重复的值，先给定一个元素，使用二分查找算法，若存在返回最后出现的位置，否则返回-1
 */
public class FindInt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] arr = new int[len];
        int target = in.nextInt();
        for(int i = 0; i < len; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(find(arr, len, target));
    }

    public static int find(int[] arr, int len, int target) {
        int lo = 0, hi = len-1;
        while(lo < len) {
            int mid = hi + (lo - hi) / 2;
            if(arr[mid] == target) {
                int index = mid;
                while(index < len -1 && arr[index+1] == target) index++;
                return index;
            } else if(arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}
