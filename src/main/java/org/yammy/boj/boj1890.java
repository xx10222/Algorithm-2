package org.yammy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1890 {
    static int n;
    static int[][] arr;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        for(int i=1;i<=n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new long[n+1][n+1];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                dp[i][j]=-1;
            }
        }



        System.out.println(dfs(1,1));

    }

    public static long dfs(int x, int y) {
        if(dp[x][y]!=-1) {
            return dp[x][y];
        }
        if(x==n && y==n) {
            return 1;
        }

        dp[x][y]=0;
        int dx = x+arr[x][y];
        int dy = y+arr[x][y];

        if(dx>n && dy>n) {
            return 0;
        }

        if(dx<=n) {
            dp[x][y] = Math.max(dp[x][y], dp[x][y]+dfs(x+arr[x][y], y));
        }
        if(dy<=n) {
            dp[x][y] = Math.max(dp[x][y], dp[x][y]+dfs(x, y+arr[x][y]));
        }

        return dp[x][y];
    }
}
