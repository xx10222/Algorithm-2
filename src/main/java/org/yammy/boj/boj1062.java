package org.yammy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1062 {

    static boolean[] visited;
    static int answer=0, k, n;
    static String[] words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        words = new String[n];
        visited = new boolean[26];

        if (k < 5) {
            System.out.println(0);
            return;
        }

        if (k == 26) {
            System.out.println(n);
            return;
        }

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine().replaceAll("anti|tica", "");
        }

        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        check(0, 0);
        System.out.println(answer);
    }

    public static void check(int alphabet, int count) {
        if (count == k - 5) {
            int temp = 0;
            for (int i = 0; i < n; i++) {
                boolean flag = true;

                for (int j = 0; j < words[i].length(); j++) {
                    if (!visited[words[i].charAt(j) - 'a']) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    temp++;
                }
            }
            answer = Math.max(answer, temp);
            return;
        }

        for (int i = alphabet; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                check(i, count + 1);
                visited[i] = false;
            }
        }
    }
}
