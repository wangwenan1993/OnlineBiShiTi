package iie.cloud.tenxun;

import java.util.*;

/**
 * Created by Administrator on 2018/9/16.
 *
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<ArrayList<Integer>> arrs = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(in.nextInt());
            list.add(in.nextInt());
            list.add(in.nextInt());
            arrs.add(list);
        }

        for(int i = 0; i < arrs.size(); i++) {
            int num_A = arrs.get(i).get(0);
            int num_B = arrs.get(i).get(1);
            int num_C = arrs.get(i).get(2);
            int j = 0;
            Map<Integer, Integer> map = new HashMap<>();
            String check = "YES";
            while(true) {
                int tmp = j * num_A % num_B;
                if(map.containsKey(tmp)) {
                    check = "NO";
                    break;
                } else {
                    if (tmp == num_C) {
                        break;
                    } else {
                        map.put(tmp, 0);
                        j++;
                    }
                }
            }
            System.out.println(check);
        }
    }
}
