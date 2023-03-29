package org.yammy.programmers;

public class 단어변환 {
    static boolean[] visited;
    static int answer;

    public static int solution(String begin, String target, String[] words) {
        answer = 0;
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }

    public static void dfs(String begin, String target, String[] words, int depth) {
        if(begin.equals(target)) {
            answer = depth;
            return;
        }

        for(int i=0;i<words.length;i++) {
            if(visited[i]) {
                continue;
            }

            int len = 0;
            for(int j=0;j<begin.length();j++) {
                if(begin.charAt(j) == words[i].charAt(j)) {
                    len++;
                }
            }

            //1글자만 다른 경우
            if(len == begin.length()-1) {
                visited[i] = true;
                dfs(words[i], target, words, depth+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"})); //4
        System.out.println(solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log"})); //0
    }
}
