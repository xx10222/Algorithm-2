package org.yammy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(t>0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            LinkedList<int[]> q = new LinkedList<>(); //읻덱스로 접근하기 위해 큐가 아닌 연결리스트 사용!

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++) {
                q.add(new int[]{i, Integer.parseInt(st.nextToken())});
            }

            int count = 0;
            while(!q.isEmpty()) {
                int[] front = q.poll();
                if(isMax(q, front[1])) {
                    count++;
                    if(front[0] == m) {
                        break;
                    }
                    continue;
                }
                q.add(front);
            }
            sb.append(count).append('\n');

            t--;
        }
        System.out.println(sb);
    }

    public static boolean isMax(LinkedList<int[]> q, int number) {
        for(int i=0;i<q.size();i++) {
            if(number < q.get(i)[1]) {
                return false;
            }
        }
        return true;
    }
}
