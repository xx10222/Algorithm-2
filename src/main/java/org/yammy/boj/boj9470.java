package org.yammy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj9470 {
    static List<Integer>[] graph;
    static int[] degree; // 진입 차수 (위상 정렬)
    static int[] order; // 순서
    static int[] maxCnt; // 진입한 최대 순서의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            graph = new ArrayList[m + 1];
            degree = new int[m + 1];
            order = new int[m + 1];
            maxCnt = new int[m + 1];

            for (int i = 1; i <= m; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 1; i <= p; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                degree[b]++;
            }

            int answer = solution(m);
            sb.append(k).append(' ').append(answer).append('\n');
        }
        System.out.println(sb);
    }

    public static int solution(int m) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= m; i++) {
            if (degree[i] == 0) {
                q.add(i);
                order[i] = 1;
                maxCnt[i] = 1;
            }
        }

        int answer = 0;
        while (!q.isEmpty()) {
            int x = q.poll();
            if (maxCnt[x] >= 2) {
                order[x]++;
            }
            answer = Math.max(answer, order[x]);
            for (int y : graph[x]) {
                degree[y]--; //진입차수(간선정보) 삭제
                if (degree[y] == 0) {
                    q.add(y);
                }

                if (order[y] == order[x]) {
                    maxCnt[y]++;
                } else if (order[y] < order[x]) {
                    order[y] = order[x];
                    maxCnt[y] = 1;
                }
            }
        }
        return answer;
    }
}
