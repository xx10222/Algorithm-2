package org.yammy.boj;

import java.util.Scanner;

public class boj10870 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fibonacci(n));
    }

    public static int fibonacci(int n) {
        if(n==0 || n==1) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
