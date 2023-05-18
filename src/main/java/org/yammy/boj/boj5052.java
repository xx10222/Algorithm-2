package org.yammy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class boj5052 {
    static class Node {
        Map<Character, Node> child = new HashMap<>();
        boolean endOfWord;
    }

    static class Trie {
        Node root = new Node();

        boolean insert(String number) {
            Node thisNode = root;
            for (int i = 0; i < number.length(); i++) {
                char c = number.charAt(i);
                // 이 문자가 없으면 새로 만듦
                if (thisNode.child.get(c) == null) {
                    thisNode.child.put(c, new Node());
                }
                // 새로 만들었거나, 존재하는 자식노드로 이동
                thisNode = thisNode.child.get(c);
                // 여기까지 동일했던 문자열이 끝나버린다면 일관성이 없다는 말이므로 false 반환
                if (thisNode.endOfWord) {
                    return false;
                }
            }
            // 입력받은 문자열 전체 노드를 타고 내려왔는데 자식노드가 존재한다는 말도 일관성이 없다는 말
            if (thisNode.child.size() != 0) {
                return false;
            }
            // 이 문자열은 일관성이 깨지지 않았으므로 마지막 자식노드에 true 넣고 true 반환
            thisNode.endOfWord = true;
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            Trie trie = new Trie();
            boolean flag = true;

            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                if (!trie.insert(br.readLine())) {
                    flag = false;
                }
            }
            System.out.println(flag ? "YES" : "NO");
        }
    }
}
