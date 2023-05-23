package org.yammy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class boj10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String str = br.readLine();
        int len = str.length();
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i) != str.charAt(len-i-1)) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}
