package org.yammy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] order = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] use = new boolean[101];
        int put = 0;
        int answer = 0;
        for (int i = 0; i < k; i++) {
            if (!use[order[i]]) {
                if (put < n) {
                    use[order[i]] = true;
                    put++;
                    continue;
                }

                List<Integer> list = new ArrayList<>();
                for (int j = i; j < k; j++) {
                    if (use[order[j]] && !list.contains(order[j])) {
                        list.add(order[j]);
                    }
                }

                if (list.size() != n) {
                    for (int j = 1; j < k; j++) {
                        if (use[j] && !list.contains(j)) {
                            use[j] = false;
                            break;
                        }
                    }
                } else {
                    use[list.get(list.size() - 1)] = false;
                }
                use[order[i]] = true;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
