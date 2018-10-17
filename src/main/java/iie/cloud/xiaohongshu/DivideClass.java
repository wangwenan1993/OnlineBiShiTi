package iie.cloud.xiaohongshu;

import java.util.Scanner;

public class DivideClass {

    public static boolean find(int x,int [] arr){
        for(int i = 0;i<arr.length;i++){
            if(x == arr[i])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int s_num = in.nextInt();
        int r_num = in.nextInt();

        Node adj[] = new Node[s_num];
        for(int i = 0; i < s_num; i++){
            adj[i] = null;
        }

        for(int i = 0; i < r_num; i++){
            int x = in.nextInt() -1;
            int y = in.nextInt() -1;
            adj[y] = new Node(x,adj[y]);
            adj[x] = new Node(y,adj[x]);
        }

        int fir[] = new int[s_num];
        int sec[] = new int[s_num];
        int _fir = 0, _sec = 0;
        for(int i = 0; i < s_num; i++){
            fir[i] = -1;
            sec[i] = -1;
        }
        for(int i = 0; i < s_num; i++){
            if(find(i,sec)){
                for(Node temp = adj[i]; temp != null; temp = temp.next){
                    if(!find(temp.val, sec) && !find(temp.val, fir)){
                        fir[_fir++] = temp.val;
                    }else if(find(temp.val, sec)){
                        System.out.println("0");
                        return;
                    }
                }
            }
            else{
                if(!find(i, fir)){
                    fir[_fir++] = i;
                }
                for(Node temp = adj[i]; temp != null; temp = temp.next){
                    if(!find(temp.val, sec) && !find(temp.val, fir)){
                        sec[_sec++] = temp.val;
                    }else if(find(temp.val, fir)){
                        System.out.println("0");
                        return;
                    }
                }
            }
        }
        System.out.println("1");
    }

    static class Node{
        int val;
        Node next;
        public Node(int val,Node next){
            this.val = val;
            this.next = next;
        }
    }
}

