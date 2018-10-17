package iie.cloud.lianjia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/8/18.
 * ��������һ�����ң����������ܷ���ʱ���ͻ��
 * ���Ƿ����ɾ������һ����ǵ�ʣ�µĻ�����Խ��У�����У��������еĿ�ɾ���Ļ
 */
public class AssignmentActivity {

    static class Times {
        int start;
        int end;
        int index;
        Times(int x, int y, int index) {
            start = x;
            end = y;
            this.index = index;
        }
    }

    public static void solution() {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        ArrayList<Times> ts = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            ts.add(new Times(scanner.nextInt(), scanner.nextInt(), i+1));
        }
        Collections.sort(ts, new Comparator<Times>() {
            @Override
            public int compare(Times o1, Times o2) {
                return ((Integer)o1.start).compareTo((Integer)o2.start);
            }
        });
//        for(Times t: ts) {
//            System.out.println(String.valueOf(t.start) + " " + String.valueOf(t.end) + " " + String.valueOf(t.index));
//        }
        ArrayList<Times> res = new ArrayList<>();
        boolean _is = true;
        for(int i = 0; i < ts.size(); i++) {
            Times pre = new Times(-1, -1, -1);
//            System.out.println();
//            System.out.println("@@@@@@@@indexi:" + i);
            _is = true;
            for(int j = 0; j < ts.size(); j++) {
//                System.out.println("@@@@@@@@indexj:" + j);
                if(i != j) {
//                    System.out.println(String.valueOf(pre.end) + " " + String.valueOf(ts.get(j).start));
                    if (ts.get(j).start < pre.end) {
                        _is = false;
                        break;
                    } else {
                        pre = ts.get(j);
                    }
                }
            }
            if(_is) res.add(ts.get(i));
        }
        System.out.println(res.size());
        for(Times t: res) {
            System.out.println(String.valueOf(t.start) + " " + String.valueOf(t.end) + " " + String.valueOf(t.index));
        }
    }

    public static void main(String args[]) {
        solution();
    }
}
