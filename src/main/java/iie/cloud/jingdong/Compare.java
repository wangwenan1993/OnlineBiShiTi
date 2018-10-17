package iie.cloud.jingdong;

import java.util.*;

/**
 * Created by Administrator on 2018/9/9.
 * 现有n个物品，每个物品有三个参数 ai , bi , ci ，定义i物品不合格品的依据是 : 若存在物品 j , 且aj>ai , bj>bi , cj>ci，则称i物品为不合格品。

 现给出n个物品的a,b,c参数，请你求出不合格品的数量。

 输入
 第一行包含一个整数n(1<=n<=500000),表示物品的数量。接下来有n行，每行有三个整数，ai,bi,ci表示第i个物品的三个参数，1≤ai,bi,ci≤109。

 输出
 输出包含一个整数，表示不合格品的数量。
 */
public class Compare {
    static class Item {
        int a;
        int b;
        int c;
        Item(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Item> items = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            items.add(new Item(in.nextInt(), in.nextInt(), in.nextInt()));
        }

        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return ((Integer) o1.a).compareTo(o2.a);
            }
        });

        int count = 0;
        for(int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            for(int j = i; j < items.size(); j++) {
                if(item.b < items.get(j).b && item.c < items.get(j).c) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
