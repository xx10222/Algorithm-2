package org.yammy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj2501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int count = 0; //약수의 개수
        int answer = 0; //약수

        for(int i=1;i<=n;i++) {
            if(n%i==0) {
                count++;
            }
            if(count == k) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
