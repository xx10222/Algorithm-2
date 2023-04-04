package org.yammy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1018 {
    static boolean[][] arr;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new boolean[n][m];
        int answer = Integer.MAX_VALUE;

        for(int i=0;i<n;i++) {
            String str = br.readLine();

            for(int j=0;j<m;j++) {
                if(str.charAt(j)=='W') {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }
            }
        }

        for(int i=0;i<n-7;i++) {
            for(int j=0;j<m-7;j++) {
                answer = Math.min(answer, check(i, j));
            }
        }
        System.out.println(answer);
    }

    public static int check(int x, int y) {
        int count = 0;
        boolean now = arr[x][y];

        for(int i=x;i<x+8;i++) {
            for(int j=y;j<y+8;j++) {
                if (arr[i][j]!=now) {
                    count++;
                }
                now = (!now);
            }
            now = (!now);
        }
        return Math.min(count, 64-count);
    }
}
