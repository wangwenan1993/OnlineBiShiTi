package iie.cloud.weicelue;

/**
 * @author wangwenan
 * @date 2018/9/21 14:49
 */
import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=n;i++){
            if(isPrime(i)){
                sb.append(i + ",");
            }
        }
        if(sb.toString().equals("")) {
            System.out.println(0);
        } else {
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());
        }
    }
    public static boolean isPrime(int a) {
        boolean flag = true;
        if (a < 2) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(a); i++) {
                if (a % i == 0) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}
