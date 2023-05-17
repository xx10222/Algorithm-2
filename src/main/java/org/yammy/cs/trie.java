package org.yammy.cs;

public class trie {
    static class Trie {
        boolean end;
        boolean pass;
        Trie[] child;

        Trie() {
            end = false;
            pass = false;
            child = new Trie[10];
        }

        public boolean insert(String str, int idx) {
            // 끝나는 단어 있으면 false 종료
            if(end) {
                return false;
            }

            // idx가 str만큼 왔을 때
            if(idx == str.length()) {
                end = true;
                if(pass) { // 더 지나가는 단어 있으면 fasle 종료
                    return false;
                } else {
                    return true;
                }
            } else {
                int next = str.charAt(idx) - '0';
                if(child[next] == null) {
                    child[next] = new Trie();
                    pass = true;
                }
                return child[next].insert(str, idx+1);
            }
        }
    }
}
