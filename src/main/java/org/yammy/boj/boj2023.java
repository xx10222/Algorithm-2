package org.yammy.boj;

import java.util.Scanner;

public class boj2023 {

    static int n;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        sb = new StringBuilder();
        dfs("2", 1);
        dfs("3", 1);
        dfs("5", 1);
        dfs("7", 1);
        System.out.println(sb);

    }

    public static void dfs(String s, int count) {
        if(count == n) {
            sb.append(s).append('\n');
            return;
        }

        for(int i=1;i<=9;i++) {
            if(isPrime(Integer.parseInt(s+i))) {
               dfs(s+i, count+1);
            }
        }
    }

    public static boolean isPrime(int n) {
        if(n==1) {
            return false;
        }
        for(int i=2;i<=Math.sqrt(n);i++) {
            if(n%i==0) {
                return false;
            }
        }
        return true;
    }
}
