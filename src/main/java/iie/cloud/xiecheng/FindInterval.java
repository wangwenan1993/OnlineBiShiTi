package iie.cloud.xiecheng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/9/4.
 */
public class FindInterval {

    static class Interval {
        int index = Integer.MIN_VALUE;
        int low = Integer.MIN_VALUE;
        int hi = Integer.MAX_VALUE;
        Interval(int index, int low, int hi) {
            this.index = index;
            this.low = low;
            this.hi = hi;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        find(in);
    }

    public static void find(Scanner in) {
        int n = in.nextInt();
        int tar = in.nextInt();
        ArrayList<Interval> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(new Interval(in.nextInt(), in.nextInt(), in.nextInt()));
        }
        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return ((Integer) o1.low).compareTo(o2.low);
            }
        });

        ArrayList<Interval> res = new ArrayList<>();
        int lo = 0, hi = list.size()-1;
        while(lo <= hi) {
            int mid = lo + (hi-lo) / 2;
            Interval tmp = list.get(mid);
            if(tmp.low > tar) hi = mid - 1;
            else {
                if(tmp.hi >= tar) res.add(new Interval(tmp.index, tmp.low, tmp.hi));
                list.remove(tmp);
                hi--;
            }
        }
        Collections.sort(res, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return ((Integer) o1.index).compareTo(o2.index);
            }
        });
        if(res.size() == 0) System.out.println("null");
        else {
            for (Interval inter : res) {
                System.out.println(inter.index);
            }
        }
    }
}
