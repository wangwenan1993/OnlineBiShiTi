package iie.cloud._360;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/8/27.
 * ��Ŀ������
 С����һ����԰����԰����һ����m�仨������ÿһ�仨�����ǲ�һ���ģ�С����1��m�е�һ��������ʾÿһ�仨��

 ����ϲ��ȥ����Щ������һ��������n�Σ�����n����������������ʲô����ʱ��˳���¼������

 ��¼��a[i]��ʾ����ʾ��i��������a[i]��仨��

 С��ܺ��棬����Q������,��[l,r]��ʱ���ڣ�С��һ�����˶��ٶ䲻ͬ�Ļ�����С����Ϊ��æ���������Ļ�������������������ش���Щ���⡣

 ����
 ����������n,m;(1<=n<=2000,1<=m<=100);�ֱ��ʾn�ο�����m��ʾһ����m�仨����

 ����������n����a[1]~a[n]��a[i]��ʾ��i�Σ�С�����Ļ�������;

 ����һ����Q(1<=Q<=1000000);��ʾС�������������

 ����Q�� ÿ�������� l,r(1<=l<=r<=n); ��ʾС����֪���ڵ�l�ε���r�Σ�С��һ�����˶��ٲ�ͬ�Ļ�����

 ���
 һ��Q��

 ÿһ�����һ���� ��ʾС����[l,r]��ʱ���ڿ��˶����ֻ���
 */
public class WatchFlowers {

    public static void main(String[] args) {
        watch();
    }

    public static void watch() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer> watch = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            watch.add(scanner.nextInt());
        }

        int times = scanner.nextInt();
        for(int i = 0; i < times; i++) {
            int l = scanner.nextInt(), r = scanner.nextInt();

//            HashSet<Integer> set = new HashSet<>();
//            for(int j = l-1; j < r; j++) {
//                set.add(watch.get(j));
//            }
//            System.out.println(set.size());
            int[] counts = new int[m+1];
            for(int k = 0; k < counts.length; k++) {
                counts[k] = 0;
            }
            for(int j = l - 1; j < r; j++) {
                counts[watch.get(j)]++;
            }
            int count = 0;
            for(int k = 0; k < counts.length; k++) {
                if(counts[k] != 0) count++;
            }
            System.out.println(count);
        }

        for(int i = 0; i < times; i++) {

        }
    }
}
