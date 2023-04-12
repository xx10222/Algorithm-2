package org.yammy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] item = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            item[i][0] = Integer.parseInt(st.nextToken());
            item[i][1] = Integer.parseInt(st.nextToken());
        }

        //dp[n] : 최대 무게가 n인 경우, 가치의 최댓값
        int[][] dp = new int[n + 1][k + 1];
        for (int a = 1; a <= k; a++) {
            for (int i = 1; i <= n; i++) {
                dp[i][a] = dp[i - 1][a];
                if (item[i][0] <= a) { //현재 아이템의 무게가 현재 무게보다 작거나 같은 경우
                    dp[i][a] = Math.max(dp[i - 1][a], item[i][1] + dp[i - 1][a - item[i][0]]);
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}
