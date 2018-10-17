package iie.cloud.baidu;

import iie.cloud.util.PrintUtil;

/**
 * @author wangwenan
 * @date 2018/10/16 23:03
 * 对只含有-1，0，1的数组排序
 */
public class Sort_101Arr {

    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, 1, 0, -1};
        quickSort(arr);
        PrintUtil.printIntArray(arr);
    }

    public static void quickSort(int[] arr) {
        if(arr == null || arr.length < 1) return;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                swap(arr, 0, i);
                break;
            }
        }
        int lo = 0; int i = lo+1, hi = arr.length-1;
        while(i <= hi) {
            if(arr[i] < arr[lo]) {
                swap(arr, i++, lo++);
            } else if(arr[i] > arr[lo]) {
                swap(arr, i, hi--);
            } else {
                i++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
