package org.yammy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            sum += arr[i];
            if(map.containsKey(arr[i])) {
                map.replace(arr[i], map.get(arr[i])+1);
            } else {
                map.put(arr[i],1);
            }
        }

        int count = -1;
        int often = 0;
        List<Integer> list = new ArrayList<>();
        for(int key : map.keySet()) {
            if(count < map.get(key)) {
                count = map.get(key);
                often = key;
                list.clear();
                list.add(key);
            } else if(count == map.get(key)) {
                list.add(key);
            }
        }

        sb.append((int)Math.round((double)sum/n)).append('\n');
        sb.append(arr[n/2]).append('\n');
        if(list.size()>1) {
            Integer[] modes = list.toArray(new Integer[list.size()]);
            Arrays.sort(modes);
            sb.append(modes[1]).append('\n');
        } else {
            sb.append(often).append('\n');
        }
        sb.append(arr[n-1] - arr[0]);
        System.out.println(sb);
    }
}
