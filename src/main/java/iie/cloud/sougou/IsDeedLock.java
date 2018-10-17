package iie.cloud.sougou;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author wangwenan
 * @date 2018/9/27 19:02
 * 判断是否会死锁，数字可能越界
 */

public class IsDeedLock {
    public static void main(String[] args) {
        // System.arraycopy(original, 0, destination, length);
        // Arrays.copyOf(original, newLength);
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        for(int i = 0; i < n; i++) {
            String ss = in.nextLine();
            String[] line = ss.split(" ");
            if(line[0].length() <= 6) {
                if(Integer.parseInt(line[0]) >= Integer.parseInt(line[1]) + Integer.parseInt(line[2])) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            } else {
                String sum = new BigInteger(line[1]).add(new BigInteger(line[2])).toString();
                if(line[0].length() < sum.length()) {
                    System.out.println("YES");
                } else if(line[0].length() > sum.length()){
                    System.out.println("YES");
                } else {
                    int res = line[0].compareTo(sum);
                    if(res >= 0) {
                        System.out.println("NO");
                    } else {
                        System.out.println("YES");
                    }
                }
            }
        }
    }
}
