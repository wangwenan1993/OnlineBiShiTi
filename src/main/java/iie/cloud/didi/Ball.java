package iie.cloud.didi;

import java.util.*;

public class Ball {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int np = in.nextInt();
        int nq = in.nextInt();
        int nr = in.nextInt();
        int[] ball_num = {np, nq, nr};
        HashMap<String, Integer> map = new HashMap<>();
        System.out.println(dfs(ball_num, -1, map));
    }

    public static int dfs(int[] nums, int pre, HashMap<String, Integer> map) {
        String key = nums[0] + " " + nums[1] + " " + nums[2] + " " + pre;
//        System.out.println(key);
        if(map.containsKey(key)) {
            return map.get(key);
        }
        int tmp = 0;
        if (nums[0] == 0 && nums[1] == 0 && nums[2] == 0) {
            return 1;
        }
        if(nums[0] > 0 && pre != 0) {
            nums[0] -= 1;
            tmp += dfs(nums, 0, map);
            nums[0] += 1;
        }
        if(nums[1] > 0 && pre != 1) {
            nums[1] -= 1;
            tmp += dfs(nums, 1, map);
            nums[1] += 1;
        }
        if(nums[2] > 0 && pre != 2) {
            nums[2] -= 1;
            tmp += dfs(nums, 0, map);
            nums[2] += 1;
        }
        map.put(nums[0] + " " + nums[1] + " " + nums[2] + " " + pre, tmp);
        return tmp;
    }
}