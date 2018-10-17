package iie.cloud.pinduoduo2;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/8/30.
 * 现有一个棋盘，格子有三种类型，木桩'x'、棋子'o'和空'.'。把棋盘立起来，棋子会顺序往下掉，如果有木桩会把棋子拦住。
 * 先给出一种棋盘的放置方式，给出最终的格局
 */
public class ChessBoard {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int c_h = in.nextInt(), c_w = in.nextInt();
        char[][] chess = new char[c_h][c_w];
        for(int i = 0; i < c_h + 1; i++) {
            String s = in.nextLine();
            char[] cc = s.toCharArray();
            for(int j = 0; j < cc.length; j++) {
                chess[i-1][j] = cc[j];
            }
        }

        for(int i = 0; i < c_w; i++) {
            int put_index = -1;
            for(int j = c_h-1; j >= 0; j--) {
                char curr = chess[j][i];
//                System.out.print(curr + " ");
                if(curr == 'x') {
                    put_index = j-1;
                } else if(curr == 'o') {
                    if(put_index == -1) {
                        chess[j][i] = '.';
                    } else {
                        chess[j][i] = '.';
                        chess[put_index--][i] = 'o';
                    }
                }
            }
        }
        for(char[] cc: chess) {
            System.out.println(String.valueOf(cc));
        }
    }
}
