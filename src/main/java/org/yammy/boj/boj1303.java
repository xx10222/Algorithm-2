package org.yammy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1303 {
    static String[][] arr;
    static boolean[][] visited;
    static int n, m;
    static int count, black, white;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new String[m][n];
        visited = new boolean[m][n];
        black = 0;
        white = 0;

        for (int i = 0; i < m; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = str[j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    count = 0;
                    dfs(i, j, arr[i][j]);

                    if (arr[i][j].equals("W")) {
                        white += count * count;
                    } else {
                        black += count * count;
                    }
                }
            }
        }

        System.out.println(white + " " + black);
    }

    public static void dfs(int x, int y, String s) {
        visited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny] && arr[nx][ny].equals(s)) {
                dfs(nx, ny, s);
            }
        }
    }
}
