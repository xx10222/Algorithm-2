package org.yammy.boj;

import java.util.Scanner;

public class boj2941 {
    public static void main(String[] args) {
        String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        for(String c : croatia) {
            str = str.replace(c, "*");
        }
        System.out.println(str.length());
    }
}
