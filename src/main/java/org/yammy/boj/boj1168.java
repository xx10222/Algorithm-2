package org.yammy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1168 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        k--; // 인덱스는 0부터 시작하기 떄문에 1을 미리 빼준다

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();

        int index = k;
        while (true) {
            sb.append(list.remove(index));
            if (list.size() == 0) {
                break;
            }
            sb.append(", ");
            index += k;
            if (index >= list.size()) {
                index %= list.size();
            }
        }
        System.out.println("<" + sb + ">");
    }
}
