package iie.cloud.zhihu;

import java.util.*;

/**
 * Created by Administrator on 2018/9/1.
 * 给定一个整数n和m，返回将整数n去掉m位后的最大整数，要求剩下的数字相对位置不变。
    输入：
        1234 2
    输出
        34
 */
public class FindMaxNumber {
    private static PriorityQueue<Element> queue;

    public static void add(Element e, int maxSize) {
        if (queue.size() < maxSize) {
            queue.add(e);
        } else {
            Element peek = queue.peek();
            if (e.compareTo(peek) > 0) {
                queue.poll();
                queue.add(e);
            }
        }
    }

    public static List<Element> sortedList() {
        List<Element> list = new ArrayList<>(queue);
        Collections.sort(list, new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return ((Integer)o2.index).compareTo(o1.index);
            }
        });
        return list;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<Element> list = new ArrayList<>();
        int i = 0;
        while(n != 0) {
            int tmp = n % 10;
            list.add(0, new Element(i++, tmp));
            n = n / 10;
        }
        if(list.size() <= m) {
            System.out.println();
            System.out.println(0);
        } else {
            int maxSize = list.size() - m;
            queue = new PriorityQueue<Element>(maxSize, new Comparator<Element>() {
                @Override
                public int compare(Element o1, Element o2) {
                    // 最大堆用o2 - o1，最小堆用o1 - o2
                    return (o1.compareTo(o2));
                }
            });
            for (Element e : list) {
                add(e, maxSize);
            }

            List<Element> res = sortedList();
//            for(Element e : res) {
//                System.out.println(e);
//            }
            int total = 0;
            for(Element e: res) {
                total = total * 10 + e.key;
            }
            System.out.println();
            System.out.println(total);
        }
    }

    static class Element implements Comparable {
        int index = 0;
        int key = 0;
        Element(int index, int key) {
            this.index = index;
            this.key = key;
        }

        @Override
        public int compareTo(Object o) {
            return ((Integer)this.key).compareTo(((Element)o).key);
        }

        @Override
        public String toString() {
            return this.index + " " + this.key;
        }
    }
}
