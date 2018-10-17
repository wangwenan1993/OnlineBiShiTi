package iie.cloud.wangyihuyu;

import java.util.*;

/**
 * @author wangwenan
 * @date 2018/9/21 19:27
 * 输入
 *  netease,factory
 *  fetease,fatease,facease,factase,factose,factore,factory,neteasy,neteary,neteory,nettory,nectory,nactory
 */
public class _2_MinModifyTimes {

    public static boolean flag = false;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] ss = in.nextLine().trim().split(",");
        String src = ss[0];
        String dst = ss[1];
//        System.out.println(src + " " + dst);
        ss = in.nextLine().trim().split(",");
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < ss.length; i++) {
            map.put(ss[i], 1);
        }
//        System.out.println(ss.length + " " + map.size());
        System.out.println(solution(src, dst, map));
    }

    public static int solution(String src, String dst, Map<String, Integer> map) {
        if(!map.containsKey(dst)) return 0;
        if(src.length() != dst.length()) return 0;
        ArrayList<Integer> need_modify = new ArrayList<>();
        ArrayList<Boolean> visited = new ArrayList<>();
        ArrayList<Character> pre_ss = new ArrayList<>();
        for(int i = 0; i < src.length(); i++) {
            if(src.charAt(i) != dst.charAt(i)) {
                need_modify.add(i);
                visited.add(false);
            }
            pre_ss.add(src.charAt(i));
        }

        dfs(dst, map, need_modify, visited, 0, pre_ss);
        if(flag) {
            return need_modify.size();
        } else {
            return 0;
        }
    }

    public static void dfs(String dst, Map<String, Integer> map, ArrayList<Integer> need_mod, ArrayList<Boolean> visited, int curr, ArrayList<Character> pre_ss) {
        if(flag) return;
        if(curr == need_mod.size()-1) {
            flag = true;
        } else {
            for (int i = 0; i < need_mod.size(); i++) {
                if (!visited.get(i)) {
                    pre_ss.set(need_mod.get(i), dst.charAt(need_mod.get(i)));
                    StringBuffer sb = new StringBuffer();
                    for (Character c : pre_ss) {
                        sb.append(c);
                    }
//                    System.out.println(i + " " + need_mod.get(i) + " " + sb.toString() + " " + curr);
                    visited.set(i, true);
                    if (map.containsKey(sb.toString())) {
                        dfs(dst, map, need_mod, new ArrayList<>(visited), curr + 1, new ArrayList<>(pre_ss));
                    }
                }
            }
        }
    }
}
