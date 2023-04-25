package org.yammy.boj;

import java.util.Scanner;

public class boj2581 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int min = 0;
        for(int i=m;i<=n;i++) {
            if(isPrime(i)) {
                if(min==0) {
                    min = i;
                }
                sum+=i;
            }
        }
        if(sum==0 && min==0) {
            System.out.println(-1);
            return;
        }
        System.out.println(sum);
        System.out.println(min);
    }
    public static boolean isPrime(int n) {
        if(n==1){
            return false;
        }
        if(n==2) {
            return true;
        }
        for(int i=2;i<=Math.sqrt(n);i++) {
            if(n%i==0) {
                return false;
            }
        }
        return true;
    }
}
