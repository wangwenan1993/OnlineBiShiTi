package iie.cloud.alibabaCePing;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/8/17.
 * ��ͼ��ĳ��������Աp����Ҫ��a��b��c��d4����ݵ����Ͱ�������������Ա��Ҫѡ��ʲô��·�ߣ�����������·�̵����͡�
 * ������ͼ����Ա���������(0,0)������·��ֻ������ͼ�еķ������ʻ��ÿ��С���������Σ��ұ߳�Ϊ1����p��d�ľ������4��
 * �������n�����͵����꣬������������·��ֵ������㿪ʼ���n�������Ͳ��ص���ʼ��ľ��룩��
 */
public class PackageRouting {

    private static class Node {
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int finalCount = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        boolean[] mark = new boolean[count];
        Node[] nodes = new Node[count];
        for (int i = 0; i < count; i ++) {
            nodes[i] = new Node(scanner.nextInt(), scanner.nextInt());
        }
        dispatch(mark, nodes, -1, count, 0, 0);
        System.out.println(finalCount);
    }

    private static void dispatch(boolean[] mark, Node[] nodes, int curr, int count, int step, int cost) {
        if (step > count) {
            finalCount = Math.min(finalCount, cost + Math.abs(nodes[curr].x) + Math.abs(nodes[curr].y));
            return;
        }
        if (curr >= 0 && mark[curr]) return;
        if (curr >= 0) mark[curr] = true;
        for (int i = 0; i < count; i++) {
            dispatch(mark, nodes, i, count, step + 1, cost + (curr < 0 ? Math.abs(nodes[i].x) + Math.abs(nodes[i].y) : nodesDistance(nodes[i], nodes[curr])));
        }
        if (curr >= 0) mark[curr] = false;
    }

    public static int nodesDistance(Node node1, Node node2) {
        return Math.abs(node1.x - node2.x) + Math.abs(node1.y - node2.y);
    }
}
