package org.yammy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7576 {
    static class tomato {
        int x;
        int y;

        tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        Queue<tomato> q = new LinkedList<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1) {
                    q.add(new tomato(i, j));
                }
            }
        }

        while(!q.isEmpty()) {
            tomato t = q.poll();

            int x = t.x;
            int y = t.y;

            for(int i=0;i<4;i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<m) {
                    if(arr[nx][ny] ==0) {
                        q.add(new tomato(nx, ny));
                        arr[nx][ny] = arr[x][y] + 1; //?
                    }
                }
            }
        }
        int result = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(arr[i][j]==0) {
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, arr[i][j]);
            }
        }
        if(result == 1) {
            System.out.println(0);
        } else {
            System.out.println(result-1);
        }

    }
}
