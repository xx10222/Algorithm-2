package org.yammy.boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj14226 {

    static class Emoticon {
        int screen;
        int clipboard;
        int time;

        public Emoticon(int screen, int clipboard, int time) {
            this.screen = screen;
            this.clipboard = clipboard;
            this.time = time;
        }
    }

    static int s;
    static boolean[][] visited; //[화면 이모티콘 수][클립보드 이모티콘 수]

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.nextInt();
        visited = new boolean[2001][2001];

        bfs();
    }

    public static void bfs() {
        Queue<Emoticon> q = new LinkedList<>();
        q.add(new Emoticon(1, 0, 0)); //디폴티 화면 이모티콘 1개

        while (!q.isEmpty()) {
            Emoticon e = q.poll();
            int eScreen = e.screen;
            int eClipboard = e.clipboard;
            int eTime = e.time;

            if (eScreen == s) {
                System.out.println(eTime);
                return;
            }

            if (eScreen > 0 && eScreen < 2000) {
                //복사
                if (!visited[eScreen][eScreen]) {
                    visited[eScreen][eScreen] = true;
                    q.add(new Emoticon(eScreen, eScreen, eTime + 1));
                }

                //삭제
                if (!visited[eScreen - 1][eClipboard]) {
                    visited[eScreen - 1][eClipboard] = true;
                    q.add(new Emoticon(eScreen - 1, eClipboard, eTime + 1));
                }
            }

            //붙여넣기
            if (eScreen > 0 && eScreen + eClipboard < 2000) {
                if(!visited[eScreen+eClipboard][eClipboard]) {
                    visited[eScreen+eClipboard][eClipboard] = true;
                    q.add(new Emoticon(eScreen+eClipboard, eClipboard, eTime+1));
                }
            }
        }
    }
}
