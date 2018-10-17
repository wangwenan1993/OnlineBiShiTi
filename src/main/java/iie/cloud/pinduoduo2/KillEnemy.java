package iie.cloud.pinduoduo2;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/8/30.
 * 给定敌人血量，现在有两类操作，一种是直接攻击攻击值为n_att，另一种是先蓄力，下次攻击攻击值为b_att，问最少需要多少次打死敌人
 */
public class KillEnemy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int blood = sc.nextInt();
        int n_att = sc.nextInt();
        int b_att = sc.nextInt();

        System.out.println(attack(blood, n_att, b_att));
    }

    public static int attack(int blood, int n_att, int b_att) {
        int ans = 0;
        if(blood <= 0) {
            return ans;
        }
        boolean flag = b_att * 1.0 / n_att > 2.0;
        if (flag) {
            ans = (blood / b_att) * 2;
            int tmp = blood % b_att;
            if(tmp > 0) {
                if (tmp <= n_att) ans++;
                else ans += 2;
            }
        } else {
            ans = blood / n_att;
            if(blood % n_att > 0) ans++;
        }
        return ans;
    }
}
