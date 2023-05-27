package org.yammy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class boj2169 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = parseInt(st.nextToken());
        int m = parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = arr[0][0];

        // 첫번째 행은 왼쪽에서 오는 값만 가능
        for(int j=1;j<m;j++) {
            dp[0][j] = arr[0][j]+dp[0][j-1];
        }

        for(int i=1;i<n;i++) {
            int[] left = new int[m]; // 왼쪽에서 오는 임시 배열
            int[] right = new int[m]; // 오른쪽에서 오는 임시 배열

            // max(왼쪽, 위쪽)
            left[0] = arr[i][0]+dp[i-1][0];
            for(int j=1;j<m;j++) {
                left[j] = Math.max(dp[i-1][j], left[j-1])+arr[i][j];
            }

            //max(오른쪽, 위쪽)
            right[m-1] = arr[i][m-1]+dp[i-1][m-1];
            for(int j=m-2;j>=0;j--) {
                right[j] = Math.max(dp[i-1][j], right[j+1]) + arr[i][j];
            }

            // i행의 모든 열을 비교하면서 최댓값을 dp에 저장
            for(int j=0;j<m;j++) {
                dp[i][j] = Math.max(left[j], right[j]);
            }
        }

        System.out.println(dp[n-1][m-1]);

    }
}
