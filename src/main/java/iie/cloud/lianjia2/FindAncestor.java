package iie.cloud.lianjia2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/9/3.
 * 小明和小红是亲兄妹，他俩一起翻了翻他们家的族谱，发现他们家非常庞大，有非常多的名字在族谱里面。族谱中会写清楚每一个人的父亲是谁，当然每个人都只会有一个父亲。

 对于祖先的定义，我们在这儿举个例子：族谱里面会写小王的父亲是小丁，小丁的父亲是小东，那么实际上小东就是小王的爷爷，也是小王的祖先。

 小明很聪明，小明理了理他们的家庭关系，很快就弄清楚了，知道了族谱中每一个人的祖先关系。

 但是小红却依旧困惑，于是问了很多问题，希望你能够解答。

 小红的问题是，请问A是B的祖先关系是什么？究竟A是不是B的祖先，或者说B是A的祖先，亦或者B和A不存在祖先关系呢。

 输入
 输入第一行包括一个整数n表示家族成员个数。

 接下来n行每行一对整数对a和b表示a是b的父亲，或者b是a的父亲，这需要你来判断。

 如果b是-1，那么a就是整个家族的根，也就是辈分最大的人，保证只有一个。

 第n+2行是一个整数m表示小红的询问个数。

 接下来m行，每行两个正整数A和B。

 表示小红想知道A是B的祖先关系。

 n,m≤40000，每个节点的编号都不超过40000。

 输出
 对于每一个询问。

 输出1表示A是B的祖先，输出2表示B是A的祖先，都不是输出0
 */
public class FindAncestor {
    static class Node {
        int val = 0;
        ArrayList<Node> childs = new ArrayList<>();
        Node parent = null;
        Node(int val, Node parent) {
            this.val = val;
            this.parent = parent;
        }
        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int fa_len = in.nextInt();
        Map<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i < fa_len; i++) {
            int first = in.nextInt();
            int second = in.nextInt();
            if(second == -1) {
                m.put(1, -1);
                continue;
            }
            if(!m.containsKey(first)) {
                m.put(first, second);
            } else {
                m.put(second, first);
            }
        }

//        for(int k: m.keySet()) {
//            System.out.print(k + ": " + m.get(k) + " ");
//        }
//        System.out.println();
        int ques = in.nextInt();
        for(int i = 0; i < ques; i++) {
            int f = in.nextInt();
            int s = in.nextInt();
            if(isAncestor(f, s, m))System.out.println(2);
            else if(isAncestor(s, f, m)) System.out.println(1);
            else System.out.println(0);
        }
    }

    public static boolean isAncestor(int a, int b, Map<Integer, Integer> fa) {
        if(!fa.containsKey(a) || !fa.containsKey(b)) return false;
        if(fa.size() > 20000) return false;
        boolean _res = false;
        while (true) {
            int tmp = fa.get(a);
            if(tmp == b){
                _res = true;
                break;
            } else if(tmp == -1) break;
            else {
                a = tmp;
            }
        }
        return _res;
    }
}
