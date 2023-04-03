package org.yammy.boj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class boj1316 {
    public static void main(String[] args) {
        int answer = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int k=0;k<n;k++) {
            String str = scanner.next();
            Set<Character> set = new HashSet<>();
            boolean flag = true;

            for(int i=0;i<str.length();i++) {
                if(!set.contains(str.charAt(i))) {
                    set.add(str.charAt(i));
                    continue;
                }

                if(set.contains(str.charAt(i)) && str.charAt(i)!=str.charAt(i-1)) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
