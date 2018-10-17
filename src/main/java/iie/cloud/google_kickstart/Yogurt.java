package iie.cloud.google_kickstart;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/8/26.
 */
public class Yogurt {

    public static void main(String[] args) {
        try {
            max();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void max() throws IOException {
        String in_filePath = "E:\\workspaces\\java\\study\\OnlineBiShiTi\\src\\google_kickstart\\A-large.in";
        String out_filePath = "E:\\workspaces\\java\\study\\OnlineBiShiTi\\src\\google_kickstart\\A-large.out";
        FileReader fileReader = new FileReader(in_filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(out_filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        int n = Integer.valueOf(bufferedReader.readLine());
        System.out.println(n);
        for(int i = 0; i < n; i++) {
            ArrayList<Integer> limits = new ArrayList<>();
            String[] line = bufferedReader.readLine().trim().split(" ");
            int data_length = Integer.valueOf(line[0]);
            final int K = Integer.valueOf(line[1]);
            line = bufferedReader.readLine().trim().split(" ");
            for(int j = 0; j < data_length; j++) {
                limits.add(Integer.valueOf(line[j]));
            }
            Collections.sort(limits);
            int k = 0, total = 0, count = 0;
            while(k < limits.size()) {
                int k_index = 0;
                while(k_index < K && k < limits.size()) {
                    if(limits.get(k) > count) {
                        total++;
                        k_index++;
                        k++;
                    } else {
                        k++;
                    }
                }
//                k_index = 0;
                count++;
            }
//            System.out.println("Case #" + (i+1) + ": " + total);
            bufferedWriter.write("Case #" + (i+1) + ": " + total + "\n");
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
