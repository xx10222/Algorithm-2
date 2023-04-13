package org.yammy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj16197 {

    static String[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer;
    static int x1, x2, y1, y2, n, m;

    static class Coin {
        int x;
        int y;

        public Coin(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;

        board = new String[n][m];
        boolean getFirst = false;
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = str[j];
                if (board[i][j].equals("o")) {
                    if (getFirst) {
                        x2 = i;
                        y2 = j;
                    } else {
                        x1 = i;
                        y1 = j;
                        getFirst = true;
                    }
                }
            }
        }

        backTracking(new Coin(x1, y1), new Coin(x2, y2), 0);

        if(answer==Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    public static void backTracking(Coin first, Coin second, int count) {
        if(count >= answer || count >= 10) {
            return;
        }

        for(int i=0;i<4;i++) {
            int exit = 0;
            int nx1 = first.x + dx[i];
            int ny1 = first.y + dy[i];
            int nx2 = second.x + dx[i];
            int ny2 = second.y + dy[i];

            if(nx1<0 || nx1 >= n || ny1<0 || ny1>=m) {
                exit++;
            }
            if(nx2<0 || nx2 >= n || ny2<0 || ny2>=m) {
                exit++;
            }

            if(exit==2) {
                continue;
            }
            if(exit==1) {
                answer = Math.min(answer, count+1);
                return;
            }

            if(board[nx1][ny1].equals("#")) {
                nx1 = first.x;
                ny1 = first.y;
            }
            if(board[nx2][ny2].equals("#")) {
                nx2 = second.x;
                ny2 = second.y;
            }
            backTracking(new Coin(nx1, ny1), new Coin(nx2, ny2), count+1);
        }
    }
}
