package iie.cloud.didi;

import java.util.*;

class StringEditDistance {

    static class Cost {
        String s = "";
        int cost = 0;
        Cost (String s, int c) {
            this.s = s;
            cost = c;
        }
    }

    public static Map<Character, Integer> s1 = new HashMap<>();
    static {
        s1.put('q', 0); s1.put('w', 0); s1.put('e', 0);
        s1.put('r', 0); s1.put('t', 0); s1.put('a', 0);
        s1.put('s', 0); s1.put('d', 0); s1.put('f', 0);
        s1.put('g', 0); s1.put('z', 0); s1.put('x', 0);
        s1.put('c', 0);s1.put('v', 0);
    }

    public static Map<Character, Integer> s2 = new HashMap<>();
    static {
        s2.put('y', 0); s2.put('u', 0); s2.put('i', 0);
        s2.put('o', 0); s2.put('p', 0); s2.put('h', 0);
        s2.put('j', 0); s2.put('k', 0); s2.put('l', 0);
        s2.put('b', 0); s2.put('n', 0); s2.put('m', 0);
    }

     public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         String[] ss = in.nextLine().trim().split(" ");
         String par = ss[0];
         ArrayList<String> coms = new ArrayList<>();
         ArrayList<Cost> costs = new ArrayList<>();
         for(int i = 1; i < ss.length; i++) {
             int _cost = getDistance(par, ss[i]);
             costs.add(new Cost(ss[i], _cost));
         }
         Collections.sort(costs, new Comparator<Cost>() {
             @Override
             public int compare(Cost o1, Cost o2) {
                 return ((Integer) o1.cost).compareTo(o2.cost);
             }
         });
         for(int i = 0; i < costs.size(); i++) {
             if(i < 3) {
                 System.out.print(costs.get(i).s + " ");
             }
         }
         System.out.println();
     }

    public static int getDistance(String strA, String strB){
        int distance=-1;

        if(null==strA||null==strB||strA.isEmpty()||strB.isEmpty()){
            return distance;
        }
        if (strA.equals(strB)) {
            return 0;
        }

        int lengthA=strA.length();
        int lengthB=strB.length();
        int length=Math.max(lengthA,lengthB);

        int array[][]=new int[length+1][length+1];

        for(int i=0;i<=length;i++){
            array[i][0]=i;
        }

        for(int j=0;j<=length;j++){
            array[0][j]=j;
        }

        for(int i=1;i<=lengthA;i++){
            for(int j=1;j<=lengthB;j++){
                int change_cost = 2;
                if(s1.containsKey(strA.charAt(i-1)) && s1.containsKey(strB.charAt(i-1)) || s2.containsKey(strA.charAt(i-1)) && s2.containsKey(strB.charAt(i-1))) {
                    change_cost = 1;
                }
                array[i][j]=min(array[i-1][j]+3,
                        array[i][j-1]+3,
                        array[i-1][j-1]+(strA.charAt(i-1)==strB.charAt(j-1)?0:change_cost));
            }
        }

        return array[lengthA][lengthB];

    }

    public static int  min(int a,int b, int c){
        return Math.min(Math.min(a,b),c);
    }
}
