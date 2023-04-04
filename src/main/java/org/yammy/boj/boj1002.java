package org.yammy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t>0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int d = (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1);
            int rPlus = (r1+r2) * (r1+r2);
            int rMinus = (r1-r2) * (r1-r2);

            if(x1==x2 && y1==y2 && r1==r2) {
                sb.append(-1);
            } else if(rPlus==d || rMinus==d) {
                sb.append(1);
            } else if (d>rPlus) {
                sb.append(0);
            } else if(rMinus<d) {
                sb.append(2);
            } else {
                sb.append(0);
            }
            sb.append('\n');

            t--;
        }
        System.out.println(sb);
    }
}
