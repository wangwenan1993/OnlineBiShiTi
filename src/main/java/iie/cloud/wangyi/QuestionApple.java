package iie.cloud.wangyi; /**
 * Created by Administrator on 2018/8/11.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionApple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> appleTotal = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            int nn = sc.nextInt();
            if (i>0) {
                appleTotal.add(nn + appleTotal.get(i-1));
            } else {
                appleTotal.add(nn);
            }
        }
        int m = sc.nextInt();
        ArrayList<Integer> questionApple = new ArrayList<Integer>();
        for(int i = 0; i < m; i++) {
            System.out.println(1+binarySearch(appleTotal, sc.nextInt(), 0, appleTotal.size()-1));
        }
    }

    public static int binarySearch(ArrayList<Integer> a, int q, int left, int right){
        if(left > right){
            return 0;
        }
        int mid = left + (right - left)/2;
        if(a.get(mid) == q){
            return mid;
        }else if(a.get(mid) < q){
            return binarySearch(a,q,mid+1,right);
        }else{
            if((mid-1)<0 || a.get(mid-1)<q){
                return mid;
            }else{
                return binarySearch(a, q, left,mid-1);
            }
        }
    }
}