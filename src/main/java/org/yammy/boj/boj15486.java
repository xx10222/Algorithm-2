package org.yammy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 2][2];
        int[] dp = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); //기간
            arr[i][1] = Integer.parseInt(st.nextToken()); //금액
        }

        int max = -1;
        for (int i = 1; i < n + 2; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }

            int nextDay = i + arr[i][0];
            if (nextDay < n + 2) {
                dp[nextDay] = Math.max(dp[nextDay], arr[i][1] + max);
            }
        }

        System.out.println(dp[n+1]);
    }
}
