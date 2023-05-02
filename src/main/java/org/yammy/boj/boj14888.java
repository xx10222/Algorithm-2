package org.yammy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14888 {

    static int n, add, sub, mul, div,max,min;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        add = Integer.parseInt(st.nextToken());
        sub = Integer.parseInt(st.nextToken());
        mul = Integer.parseInt(st.nextToken());
        div = Integer.parseInt(st.nextToken());

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        calculate(0, 0, 0, 0, 1, numbers[0]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void calculate(int a, int s, int m, int d, int index, int result) {
        if (index == n) {
            if(result>max) {
                max = result;
            }
            if(min>result) {
                min = result;
            }
            return;
        }

        if(a<add) {
            calculate(a+1, s, m,d,index+1, result+numbers[index]);
        }
        if(s<sub) {
            calculate(a, s+1, m,d,index+1, result-numbers[index]);
        }
        if(m<mul) {
            calculate(a, s, m+1,d,index+1, result*numbers[index]);
        }
        if(d<div) {
            calculate(a, s, m,d+1,index+1, (int)result/numbers[index]);
        }

    }
}
