package iie.cloud.sougou;

import java.util.Scanner;

/**
 * @author wangwenan
 * @date 2018/9/27 19:02
 * 匹配*号
 */

public class MatchAsterisk {
    public static void main(String[] args) {
        // System.arraycopy(original, 0, destination, length);
        // Arrays.copyOf(original, newLength);
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        System.out.println();
        for(int i = 0; i < n+1; i++) {
            if(i == n) {
                in.nextLine();
                break;
            }
            boolean flag = true;
            String pat = in.nextLine();
            String num = in.nextLine();
            int sum = 0;
            int pat_i = 0, num_i = 0;
            if(num.equals("")) flag = false;
            else {
                while(pat_i < pat.length() && num_i < num.length()) {
                    if(pat_i == 0 && pat.charAt(pat_i) == '*') {
                        num_i++;
                        pat_i++;
                    }
                    if(pat.charAt(pat_i) == '*' && pat_i > 0 && pat.charAt(pat_i-1) == '*') {
                        num_i++;
                        pat_i++;
                    }
                    if(pat.charAt(pat_i) == '*') {
                        int tmp = sum % 10;
                        if(Integer.parseInt(String.valueOf(num.charAt(num_i))) == tmp) num_i++;
                        else {
                            pat_i++;
                            num_i++;
                            sum = 0;
                        }
                    } else {
                        sum += Integer.parseInt(String.valueOf(pat.charAt(pat_i)));
                        if(pat.charAt(pat_i) != num.charAt(num_i)) {
                            flag = false;
                            break;
                        } else {
                            pat_i++;
                            num_i++;
                        }
                    }
                }
            }
            if(pat_i < pat.length() && pat.charAt(pat.length()-1) != '*'|| num_i < num.length()) flag = false;
            if(flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
