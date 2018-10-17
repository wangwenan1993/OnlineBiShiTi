package iie.cloud.tenxun_mian;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author wangwenan
 * @data 2018/8/27 14:33
 * 实现一个函数，输入整型数字，返回对应的中文读音
 */
public class Int2String {

    public static void main(String[] args) {
        try {
            System.out.println(int2Str(-1601000303));
        } catch (Exception e) {

        }
    }

    public static String int2Str(int x) {
        if(x == 0) return "零";
        int flag = x >=0 ? 1 : -1;
        if(x < 0) x = -x;
        int pre_low = -1;
        Map<Integer, String> m = new HashMap<>();
        m.put(0, "零"); m.put(1, "一"); m.put(2, "二"); m.put(3, "三"); m.put(4, "四");
        m.put(5, "五"); m.put(6, "六"); m.put(7, "七"); m.put(8, "八"); m.put(9, "九");
        List<String> digits = Arrays.asList("", "十", "百", "千");
        List<String> degrees = Arrays.asList("", "万", "亿");
        StringBuilder sb = new StringBuilder("");
        int count = 0;
        while(x != 0) {

            sb.append(count / 4 > 0 && count % 4 == 0 ? degrees.get(count/4) : "");

            int tmp = x % 10;
            if(tmp == 0) {
                if(pre_low != 0) {
                    sb.append(m.get(tmp));
                }
            } else {
                sb.append(digits.get(count % 4));
                sb.append(m.get(tmp));
            }
            count++;
            pre_low = tmp;
            x = x / 10;
        }
        sb.reverse();
        return (flag == -1 ? "负" : "") + sb.toString();
    }
}
