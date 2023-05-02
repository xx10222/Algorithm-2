package org.yammy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] heights = new int[w];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<w;i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for(int i=1;i<w-1;i++) {
            int left = 0;
            int right = 0;

            for(int j=0;j<i;j++) {
                left = Math.max(left, heights[j]);
            }
            for(int j=i+1;j<w;j++) {
                right = Math.max(right, heights[j]);
            }

            if(heights[i]<left && heights[i]<right) {
                int temp = Math.min(left, right);
                answer += temp-heights[i];
            }
        }
        System.out.println(answer);
    }
}
