package org.yammy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import static java.lang.System.in;

public class boj9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    stack.push('(');
                } else {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if(!stack.isEmpty()) {{
                flag = false;
            }}
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}
