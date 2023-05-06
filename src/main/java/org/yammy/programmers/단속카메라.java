package org.yammy.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 단속카메라 {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        int now = 0;
        int index = 0;
        while(index < routes.length) {
            if(routes[now][1]<routes[index][0]) {
                now = index;
                answer++;
            }
            index++;
        }
        return answer;
    }
}
