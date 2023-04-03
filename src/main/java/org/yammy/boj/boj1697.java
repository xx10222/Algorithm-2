package org.yammy.boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1697 {
    static int[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        if(n==k) {
            System.out.println(0);
            return;
        }

        visited = new int[100001];
        System.out.println(bfs(n, k));
    }

    public static int bfs(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = 1;

        while(!q.isEmpty()) {
            int cur = q.poll();

            if(cur == k) {
                return visited[cur] - 1;
            }
            if(cur-1>=0 && visited[cur-1]==0) {
                visited[cur-1] = visited[cur]+1;
                q.add(cur-1);
            }
            if(cur+1<=100000 && visited[cur+1]==0) {
                visited[cur+1] = visited[cur]+1;
                q.add(cur+1);
            }
            if(2*cur<=100000 && visited[2*cur]==0) {
                visited[2*cur] = visited[cur]+1;
                q.add(2*cur);
            }
        }
        return -1;
    }
}
