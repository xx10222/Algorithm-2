package org.yammy.boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj2164 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++) {
            q.add(i);
        }

        while(q.size()!=1) {
            q.poll();
            int num = q.poll();
            q.add(num);
        }
        System.out.println(q.peek());
    }
}
