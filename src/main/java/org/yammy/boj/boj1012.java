package org.yammy.boj;

import java.util.Scanner;

public class boj1012 {
    static boolean[][] visited;
    static int answer;
    static int m, n, k;
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t > 0) {
            answer = 0;
            m = scanner.nextInt();
            n = scanner.nextInt();
            k = scanner.nextInt();
            arr = new int[m][n];
            visited = new boolean[m][n];

            for (int i = 0; i < k; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                arr[x][y] = 1;
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && arr[i][j]==1) {
                        dfs(i, j);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
            t--;
        }

    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY] && arr[nextX][nextY]==1) {
                dfs(nextX, nextY);
            }
        }
    }
}
