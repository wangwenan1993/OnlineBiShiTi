package iie.cloud.tenxun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/9/16.
 */
public class Main2 {
    public static void main(String[] agrs) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int res = 0;
        ArrayList<HashSet<Integer>> road = new ArrayList<>(n+1);
        ArrayList<HashSet<Integer>> _road = new ArrayList<>(n+1);
        ArrayList<Integer> fro = new ArrayList<>(n+1);
        ArrayList<Integer> to = new ArrayList<>(n+1);
        for(int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            road.get(x).add(y);
            _road.get(y).add(x);
        }
        for(int i = 1; i <= n; i++) {
            ArrayList<Boolean> visit = new ArrayList<>(n+1);
            ArrayList<Boolean> _visit = new ArrayList<>(n+1);
            for(int j = 0; j < visit.size(); j++) {
                visit.add(j, false);
            }
            for(int j = 0; j < _visit.size(); j++) {
                _visit.add(j, false);
            }
            int x = dfs(i, road, visit);
            int y = dfs(i, _road, _visit);
            if(y > x) {
                res++;
            }
        }
        System.out.println(res);
    }

    public static int dfs(int curr, ArrayList<HashSet<Integer>> road, ArrayList<Boolean> visit) {
        visit.add(curr, true);
        int res = 1;
        for(Integer hh: road.get(curr)) {
            if(visit.get(hh)) {
                continue;
            }
            res += dfs(curr, road, visit);
        }
        return res;
    }
}


