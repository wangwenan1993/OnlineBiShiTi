package iie.cloud.wangyi;

import java.util.ArrayList;
import java.util.Scanner;

public class MinimumInblance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int operates = sc.nextInt();
        int[] towerHead = new int[n];
        for(int i = 0; i < n; i++){
            towerHead[i] = sc.nextInt();
        }
        ArrayList moves = new ArrayList();
        int _operates = 0;
        for(int i = 0; i < operates; i++) {
            int min = towerHead[0], max = towerHead[0], min_i = 0, max_i = 0;
            for(int j = 0; j < towerHead.length; j++) {
                int temp = towerHead[j];
                if(temp > max) {
                    max_i = j;
                    max = temp;
                }
                if(temp < min) {
                    min_i = j;
                    min = temp;
                }
            }
            if(max - min >= 2) {
                towerHead[min_i] += 1;
                towerHead[max_i] -= 1;
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(max_i+1);
                list.add(min_i+1);
                moves.add(list);
                _operates++;
            } else {
                break;
            }
        }
        int min = towerHead[0], max = towerHead[0];
        for(int j = 0; j < towerHead.length; j++) {
            int temp = towerHead[j];
            if(temp > max) {
                max = temp;
            }
            if(temp < min) {
                min = temp;
            }
        }
        System.out.println(String.valueOf(max-min) + " " + String.valueOf(_operates));
        for(Object o : moves) {
            ArrayList<Integer> l = (ArrayList<Integer>) o;
            System.out.println(String.valueOf(l.get(0)) + " " + String.valueOf(l.get(1)));
        }
    }

}