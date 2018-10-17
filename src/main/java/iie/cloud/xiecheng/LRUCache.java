package iie.cloud.xiecheng;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/9/4.
 */
public class LRUCache {

    public static int SIZE = Integer.MAX_VALUE;
    public static float LOAD_FACTOR = 1.0f;
    public static LinkedHashMap<Integer, Integer> map;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SIZE = Integer.parseInt(in.nextLine());
        map = new LinkedHashMap(SIZE, LOAD_FACTOR, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > SIZE;
            }
        };

        while (in.hasNextLine()) {
            String op = in.nextLine().trim();
            String[] ss = op.split(" ");
            if(ss[0].equals("p")) {
                map.put(Integer.parseInt(ss[1]), Integer.parseInt(ss[2]));
            } else {
                System.out.println(map.get(Integer.parseInt(ss[1])));
            }
        }
    }

    public synchronized void put(Integer key, Integer value) {
        map.put(key, value);
    }

    public synchronized Integer get(Integer key) {
        return map.get(key);
    }

    public synchronized int size() {
        return map.size();
    }
}
