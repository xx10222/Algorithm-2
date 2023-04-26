package org.yammy.boj;

import java.util.Scanner;

public class boj1789 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long s = scanner.nextLong();
        long sum = 0;
        int count = 0;
        for(int i=1;;i++) {
            if(sum > s) {
                break;
            }
            sum += i;
            count++;
        }
        System.out.println(count-1);
    }
}
