package org.yammy.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int n, m;

    public static int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];

        visited[0][0] = true;
        bfs(0, 0, maps);

        answer = maps[n-1][m-1];
        if(answer==1) {
            answer=-1;
        }
        return answer;
    }

    public static void bfs(int x, int y, int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int now[] = q.poll();
            int nx = now[0];
            int ny = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nx + dx[i];
                int nextY = ny + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
                    if(maps[nextX][nextY]==1 && !visited[nextX][nextY]) {
                        q.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                        maps[nextX][nextY] = maps[nx][ny] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
