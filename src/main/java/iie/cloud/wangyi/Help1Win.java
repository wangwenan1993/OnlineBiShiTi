package iie.cloud.wangyi;

import java.util.*;

/**
 * Created by Administrator on 2018/9/8.
 */
public class Help1Win {
    static class Vote {
        int id;
        int cost;
        Vote(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }
    }
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        Scanner in = new Scanner(System.in);
        List<Vote> list = new ArrayList<>();
        int n = in.nextInt();
        int m = in.nextInt();
        for(int i = 0; i < n; i++) {
            int id = in.nextInt();
            int cost = in.nextInt();
            list.add(new Vote(id, cost));
            map.put(id, map.getOrDefault(id, 0) + 1);
        }
        int total_cost = 0;
        while (!isWin(map)) {
            break;
        }
        System.out.println(total_cost);
    }

    public static boolean isWin(Map<Integer, Integer> map) {
        int max = Integer.MIN_VALUE;
        int index = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() > max) {
                max = entry.getValue();
                index = entry.getKey();
            }
        }
        if (index == 1) return true;
        else return false;
    }
}
