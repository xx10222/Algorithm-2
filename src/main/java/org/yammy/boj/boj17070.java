package org.yammy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj17070 {
    static int n;
    static int[][] arr;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = 0;
        //파이프 끝점 기준 -> (1,2) || 가로-0, 세로-1, 대각선-2
        dfs(1, 2, 0);
        System.out.println(answer);
    }

    public static void dfs(int x, int y, int direction) {
        if (x == n && y == n) {
            answer++;
            return;
        }

        switch (direction) {
            case 0:
                if (y + 1 <= n && arr[x][y + 1] == 0) {
                    dfs(x, y + 1, 0);
                }
                break;
            case 1:
                if (x + 1 <= n && arr[x + 1][y] == 0) {
                    dfs(x + 1, y, 1);
                }
                break;
            case 2:
                if (y + 1 <= n && arr[x][y + 1] == 0) {
                    dfs(x, y + 1, 0);
                }

                if (x + 1 <= n && arr[x + 1][y] == 0) {
                    dfs(x + 1, y, 1);
                }
                break;
        }

        //대각선
        if (x + 1 <= n && y + 1 <= n && arr[x + 1][y] == 0 && arr[x][y + 1] == 0 && arr[x + 1][y + 1] == 0) {
            dfs(x+1, y+1, 2);
        }
    }
}
