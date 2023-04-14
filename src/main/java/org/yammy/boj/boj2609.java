package org.yammy.boj;

import java.util.Scanner;

public class boj2609 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int great = gcd(Math.max(a,b), Math.min(a,b));
        System.out.println(great);
        System.out.println(a*b/great);
    }

    public static int gcd(int big, int small) {
        if (small == 0) {
            return big;
        }
        return gcd(small, big % small);
    }
}
