package org.yammy.boj;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class boj1931 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]) {
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
            }
        });

        int count=0;
        int prev = 0;
        for(int i=0;i<n;i++) {
            if(prev<=arr[i][0]) {
                prev = arr[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
