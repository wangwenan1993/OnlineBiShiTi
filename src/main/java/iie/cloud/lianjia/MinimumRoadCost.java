package iie.cloud.lianjia;

import java.util.*;

/**
 * Created by Administrator on 2018/8/15.
 * 现有多个村庄，海拔固定，现在希望在这些村庄之间修路，是的所有村庄互达；
 * 而两个村庄间的修路费用等于海拔更高的村庄的海拔，最小化修路费用
 */
public class MinimumRoadCost {

    public static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) {
//        Permutation();
        Permutation2();
        System.out.println(minCost);
    }
    public static void Permutation() {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        boolean[] mark = new boolean[count];
        int[] nodes = new int[count];
        for (int i = 0; i < count; i ++) {
            nodes[i] = scanner.nextInt();
        }
        int curr = 0;
        if (nodes != null && nodes.length > 0) {
            PermutationHelper(nodes, 0, curr);
        }
    }

    private static void PermutationHelper(int[] nodes, int i, int curr_cost) {
        if(i == 0) curr_cost = 0;
        else curr_cost += Math.max(nodes[i], nodes[i-1]);
        if (i == nodes.length - 1) {
            minCost = minCost < curr_cost ? minCost : curr_cost;

        } else {
            Set<Integer> charSet = new HashSet<Integer>();
            for (int j = i; j < nodes.length; ++j) {
                if (j == i || !charSet.contains(nodes[j])) {
                    charSet.add(nodes[j]);
                    swap(nodes, i, j);
                    PermutationHelper(nodes, i + 1, curr_cost);
                    swap(nodes, j, i);
                }
            }
        }
    }

    private static void swap(int[] cs, int i, int j) {
        int temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }


    public static void Permutation2() {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        boolean[] mark = new boolean[count];
        int[] nodes = new int[count];
        for (int i = 0; i < count; i ++) {
            nodes[i] = scanner.nextInt();
        }
        Arrays.sort(nodes);
        int tmp = sum(nodes);
        minCost = minCost < tmp ? minCost : tmp;
        int len = nodes.length;
        while (true) {
            int lIndex = len - 1;
            int rIndex;
            while (lIndex >= 1 && nodes[lIndex - 1] >= nodes[lIndex]) {
                lIndex--;
            }
            if (lIndex == 0)
                break;
            rIndex = lIndex;
            while (rIndex < len && nodes[rIndex] > nodes[lIndex - 1]) {
                rIndex++;
            }
            swap(nodes, lIndex - 1, rIndex - 1);
            reverse(nodes, lIndex);

            tmp = sum(nodes);
            minCost = minCost < tmp ? minCost : tmp;
        }
    }

    private static void reverse(int[] chars, int k) {
        if (chars == null || chars.length <= k)
            return;
        int len = chars.length;
        for (int i = 0; i < (len - k) / 2; i++) {
            int m = k + i;
            int n = len - 1 - i;
            if (m <= n) {
                swap(chars, m, n);
            }
        }
    }

    private static int sum(int arr[]) {
        int tmp = 0;
        for(int i = 1; i < arr.length; i++) {
            tmp += Math.max(arr[i-1], arr[i]);
        }
        return tmp;
    }
}
