package org.yammy.boj;

import java.util.*;

public class boj1038 {
    static List<Long> list;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if(n<10) {
            System.out.println(n);
        } else if(n>1022) {
            System.out.println(-1);
        } else {
            list = new ArrayList<>();
            for(int i=0;i<10;i++) {
                backTracking(i, 1);
            }
            Collections.sort(list);
            System.out.println(list.get(n));
        }
    }

    public static void backTracking(long num, int index) {
        if(index>10) {
            return;
        }

        list.add(num);
        for(int i=0;i<num%10;i++) {
            backTracking(num*10+i, index+1);
        }
    }
}
