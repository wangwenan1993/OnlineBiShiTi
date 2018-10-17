package iie.cloud.xiaohongshu;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/9/15.
 */
public class ReverseList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        reverse(in);
    }

    public static void reverse(Scanner in) {
        String ss = in.nextLine();
        if(ss.trim().equals("")) return;
        String[] arr = ss.trim().split(" ");
        int[] array = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            array[i] = Integer.parseInt(arr[i]);
        }
        int k = in.nextInt();
        int n = array.length / k, m = array.length % k;
        for(int i = 0; i <= n; i++) {
            if(i < n) {
                for(int j = (i+1)*k-1; j >= i*k; j--) {
                    System.out.print(array[j] + " ");
                }
            } else if( m > 0){
                for(int j = i*k; j < array.length; j++) {
                    System.out.print(array[j] + " ");
                }
            }
        }
        System.out.println();
    }

    public static void re(Scanner in) {
        String ss = in.nextLine();
        String[] arr = ss.trim().split(" ");
        ListNode root = new ListNode(Integer.parseInt(arr[0])), tmp = root;
        for(int i = 1; i < arr.length; i++) {
            tmp.next = new ListNode(Integer.parseInt(arr[i]));
            tmp = tmp.next;
        }
        int k = in.nextInt();
    }
}

