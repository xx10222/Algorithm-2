package org.yammy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj16953 {
    static long b;
    static int answer;
    static Set<Long> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        answer = Integer.MAX_VALUE;
        set = new HashSet<>();
        dfs(a, 1);
        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        System.out.println(answer);
    }

    public static void dfs(Long num, int depth) {
        set.add(num);
        if (num == b) {
            answer = Math.min(answer, depth);
            return;
        }
        Long next = num * 2;
        if (next <= b && !set.contains(next)) {
            dfs(next, depth + 1);
        }

        next = num * 10 + 1;
        if (next <= b && !set.contains(next)) {
            dfs(next, depth + 1);
        }
    }
}
