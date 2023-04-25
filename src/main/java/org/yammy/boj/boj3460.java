package org.yammy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj3460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            int n = Integer.parseInt(br.readLine());
            String binary = Integer.toBinaryString(n);
            int len = binary.length()-1;

            StringBuilder sb = new StringBuilder();
            for(int i=binary.length()-1;i>=0;i--) {
                if(binary.charAt(i)=='1') {
                    sb.append(len-i).append(" ");
                }
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb);
        }
    }
}
