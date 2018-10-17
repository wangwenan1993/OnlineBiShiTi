package iie.cloud.google_kickstart;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2018/8/26.
 */
public class Milk {

    public static void main(String[] args) {
        try {
            min();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void min() throws IOException {
        String in_filePath = "E:\\workspaces\\java\\study\\OnlineBiShiTi\\src\\google_kickstart\\B-large.in";
        String out_filePath = "E:\\workspaces\\java\\study\\OnlineBiShiTi\\src\\google_kickstart\\B-large.out";
        FileReader fileReader = new FileReader(in_filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(out_filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        int n = Integer.valueOf(bufferedReader.readLine());
        System.out.println(n);
        for(int i = 0; i < n; i++) {
            ArrayList<String> fri_list = new ArrayList<>();
            ArrayList<String> for_list = new ArrayList<>();
            String[] line = bufferedReader.readLine().trim().split(" ");
            int fri_len = Integer.valueOf(line[0]);
            int for_len = Integer.valueOf(line[1]);
            int cho_len = Integer.valueOf(line[2]);
            for(int j = 0; j < fri_len; j++) {
                fri_list.add(bufferedReader.readLine().trim());
            }
            for(int j = 0; j < for_len; j++) {
                for_list.add(bufferedReader.readLine().trim());
            }
            System.out.println("fri_len: " + fri_len + " for_len: " + for_len + " cho_len: " + cho_len);

            ArrayList<String> per_list = new ArrayList<>();
            PermutationHelper(cho_len, per_list);
//            System.out.println("####per_list");
//            for(String s: per_list) System.out.println(s);
//            System.out.println("$$$$per_list");
            per_list.removeAll(for_list);
//            System.out.println("####per_list");
//            for(String s: per_list) System.out.println(s);
//            System.out.println("$$$$per_list");
            int min = Integer.MAX_VALUE;
            for(String per_ss: per_list) {
                int total = 0;
                for(String fri_ss: fri_list) {
                    for(int k = 0; k < fri_ss.length(); k++) {
                        total += per_ss.charAt(k) == fri_ss.charAt(k) ? 0 : 1;
                    }
                }
//                System.out.println("total: " + total);
                min = total < min ? total : min;
            }
            System.out.println("Case #" + (i+1) + ": " + min);
            bufferedWriter.write("Case #" + (i+1) + ": " + min + "\n");
        }
        bufferedReader.close();
        bufferedWriter.close();
    }

    public static String construct01String(int len) {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < len; i++) {
            if(i % 2 == 0) {
                sb.append('0');
            } else {
                sb.append('1');
            }
        }
        return sb.toString();
    }

    public static void PermutationHelper(int length, ArrayList<String> list) {
        for(int i = 0; i < Math.pow(2, length); i++) {
            String ss = Integer.toBinaryString(i);
            StringBuilder sb = new StringBuilder("");
            for(int j = ss.length(); j < length; j++) {
                sb.append('0');
            }
            list.add(sb.toString() + ss);
        }
    }

    public static void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
