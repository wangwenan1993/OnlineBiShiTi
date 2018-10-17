package iie.cloud.lianjia2;

import iie.cloud.util.PrintUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/9/3.
 * 多米诺骨牌大家想必都不陌生，现在有n块多米诺骨牌放在x轴上，每一块骨牌有一个所在位置下标和高度，每一块骨牌都只会向x轴正方向倒下，
 * 当处于位置x0，高度为h0的多米诺骨牌倒下，会压倒[x + 1, x + h - 1]内的所有多米诺骨牌，对于每一块骨牌。我们希望知道，如果我把这块骨牌推倒，那么至多可以倒下多少块骨牌。

 输入
 输入第一行包含一个正整数n，表示多米诺骨牌的数量(1<=n<=10^5)

 接下来n行，每行包含两个正整数x,h，分别表示第i块多米诺骨牌的位置和高度(-10^8<=x<=10^8,2<=h<=10^8)。保证不会有两块骨牌在同一高度。

 输出
 对于每个测试数据，输出一行， 包含n个正整数，第i个数字表示，如果推倒第i块多米诺骨牌，可以使得多少个骨牌倒下。

 样例输入
 4
 16 5
 20 5
 10 10
 18 2
 样例输出
 3 1 4 1
 */
public class Domino {
    static class Do {
        int index = -1;
        int x = Integer.MIN_VALUE;
        int x_h = Integer.MIN_VALUE;
        int count = 1;
        Do(int index, int x, int x_h) {
            this.index = index;
            this.x = x;
            this.x_h = x_h;
        }

        @Override
        public String toString() {
            return index + ": " + x + " " + x_h + " " + count;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Do> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
//            int index = in.nextInt();
            int x = in.nextInt();
            int h = in.nextInt();
            list.add(new Do(i, x, Math.max(x+1, x+h-1)));
        }
        dp(n, list);
    }

    public static void dp(int n, ArrayList<Do> list) {
        Collections.sort(list, new Comparator<Do>() {
            @Override
            public int compare(Do o1, Do o2) {
                return ((Integer) o1.x).compareTo(o2.x);
            }
        });

        for(Do _do: list) {
            System.out.println(_do);
        }

        for(int i = list.size()-2; i>=0; i--) {
            Do _do = list.get(i);
            int count = 0;
            int j = i+1;
            for(; j < list.size() && _do.x_h >= list.get(j).x; j++) {
                list.get(i).count = Math.max(list.get(i).count, 1 + count + list.get(j).count);
                count++;
            }
        }

        Collections.sort(list, new Comparator<Do>() {
            @Override
            public int compare(Do o1, Do o2) {
                return ((Integer) o1.index).compareTo(o2.index);
            }
        });
        for(Do _do: list) {
            System.out.print(_do.count + " ");
        }
        System.out.println();
    }
}
