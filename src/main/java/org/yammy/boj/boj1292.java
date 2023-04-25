package org.yammy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] arr = new int[1001];
        int count = 1;
        for(int i=1;i<=b;i++) {
            for(int j=0;j<i;j++) {
                if(count==1001) {
                    break;
                }
                arr[count] = i;
                count++;
            }
        }
        int answer = 0;
        for(int i=a;i<=b;i++) {
            answer += arr[i];
        }
        System.out.println(answer);
    }
}
