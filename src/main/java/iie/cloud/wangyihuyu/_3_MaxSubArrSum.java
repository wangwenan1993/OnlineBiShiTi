package iie.cloud.wangyihuyu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author wangwenan
 * @date 2018/9/21 20:28
 */
public class _3_MaxSubArrSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(solution(arr, k));
    }

    public static int solution(int[] arr, int k) {
        PriorityQueue<Integer> maxHeapDivide = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        PriorityQueue<Integer> minHeapSub = new PriorityQueue<Integer>();

        ArrayList<Integer> divide =  new ArrayList<>();

        int max_sum = 0;
        int pre_divide = -1;
        int sub_sum = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < 0) {
                if(i - pre_divide > 1) {
                    minHeapSub.add(sub_sum);
                    System.out.println(sub_sum);
                }
                maxHeapDivide.add(arr[i]);
                sub_sum = 0;
                pre_divide = i;
            } else {
                sub_sum += arr[i];
                max_sum += arr[i];
            }
        }
        int tmp = arr.length - maxHeapDivide.size();
        if(tmp >= k) {
            if(minHeapSub.size() > k) {
                for(int i = minHeapSub.size(); i > k; i--) {
                    max_sum -= minHeapSub.poll();
                }
            }
        } else {
            for(int i = tmp; i < k; i++) {
                max_sum += maxHeapDivide.poll();
            }
        }
        return max_sum;
    }
}
