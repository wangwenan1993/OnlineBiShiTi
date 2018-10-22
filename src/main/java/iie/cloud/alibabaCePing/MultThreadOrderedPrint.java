package iie.cloud.alibabaCePing;

/**
 * @author wangwenan
 * @date 2018/10/22 16:43
 */


import java.util.ArrayList;

//评测题目:
/**
 * 顺序递增打印正整数，从1开始打印到100，中间换行分隔。不允许重复打印出相同的数字，比如打印结果里出现2个5，3个6之类的。
 *
 * 要求如下：
 * 1、使用三个线程A、B、C，其中线程A打印3的倍数，B打印5的倍数，C打印其他数字。
 * 2、使用Java语言实现，不使用IDE，直接在页面作答。
 * 3、允许有不影响代码设计上的小的编译错误，比如方法名错误，标点错误等。
 * 4、允许查Java API Document，允许使用第三方类库。
 */

public class MultThreadOrderedPrint {
    private static ArrayList<Integer> sList;
    private static int curr = 0;
    static {
        sList = new ArrayList<Integer>();
        for(int i = 0; i < 100; i++) {
            sList.add(i+1);
        }
    }

    public synchronized static int getNumber(int flag) {
        int res = 0;
        if(curr >= sList.size()) {
            return -1;
        } else {
            int tmp = sList.get(curr);

            if(flag == 0 && tmp % 3 == 0 || flag == 1 && tmp % 5 == 0 || flag == 2 && tmp % 3 != 0 && tmp % 5 != 0) {
                curr++;
                System.out.println(tmp);
                res = tmp;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Worker worker1 = new Worker(0);
        Worker worker2 = new Worker(1);
        Worker worker3 = new Worker(2);
        Thread thread1 = new Thread(worker1);
        Thread thread2 = new Thread(worker2);
        Thread thread3 = new Thread(worker3);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Worker implements Runnable {
    private int flag;
    public Worker(int flag) {
        this.flag = flag;
    }
    public void run() {
        while(true) {
            int res = MultThreadOrderedPrint.getNumber(flag);
            if(res > 0) {
//                System.out.println(res);
                continue;
            } else if(res == 0){
                continue;
            } else {
                break;
            }
        }
    }
}
