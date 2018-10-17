package iie.cloud._360;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/8/27.
 * ����һ��������Ҫ�������еľ���ͬʱ������������
 */
public class BuildCity {

    public static void main(String[] args) {
        build();
    }

    public static void build() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long min_x = Long.MAX_VALUE, max_x = Long.MIN_VALUE, min_y = Long.MAX_VALUE, max_y = Long.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            long _x = scanner.nextLong();
            long _y = scanner.nextLong();
            min_x = _x < min_x? _x : min_x;
            max_x = _x > max_x ? _x : max_x;
            min_y = _y < min_y ? _y : min_y;
            max_y = _y > max_y ? _y : max_y;
        }
        Long len_x = max_x - min_x;
        Long len_y = max_y - min_y;
        Long len = len_x > len_y ? len_x : len_y;
        System.out.println(len * len);
    }
}
