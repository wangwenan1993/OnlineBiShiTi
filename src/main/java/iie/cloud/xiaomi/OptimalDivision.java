package iie.cloud.xiaomi;

import java.util.Scanner;

/**
 * @author wangwenan
 * @date 2018/9/20 20:00
 * 依次给出n个正整数A1，A2，… ，An，将这n个数分割成m段，每一段内的所有数的和记为这一段的权重， m段权重的最大值记为本次分割的权重。问所有分割方案中分割权重的最小值是多少？
 *
 * 输入
 * 第一行依次给出正整数n，m，单空格切分；(n <= 10000, m <= 10000, m <= n)
 * 第二行依次给出n个正整数单空格切分A1，A2，… ，An  (Ai <= 10000)
 * 输出
 * 分割权重的最小值
 *
 *
 * 样例输入
 * 5 3
 * 1 4 2 3 5
 * 样例输出
 * 5
 */
public class OptimalDivision {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int left = 0;
        int right = 0;

        for(int num: arr) {
            if(num > left) {
                left = num;
            }
            right += num;
        }

        while(left < right) {
            int mid = (left + right) / 2;
            if(judge(arr, mid, n, m)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }

    public static boolean judge(int[] arr, int min_sum, int n, int m) {
        int count = 0;
        int sum_left = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] > min_sum) return false;
            if(sum_left + arr[i] > min_sum) {
                count += 1;
                sum_left = arr[i];
                if(count > m - 1)
                    return false;
            } else {
                sum_left += arr[i];
            }
        }
        return true;
    }
}


