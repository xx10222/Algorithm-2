package org.yammy.programmers;

public class 네트워크 {
    static boolean[] visited;
    public static int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];

        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                dfs(computers, i);
                answer++;
            }
        }

        return answer;
    }

    public static void dfs(int[][] computers, int index) {
        visited[index] = true;

        for(int i=0;i<computers.length;i++) {
            if(index!=i && computers[index][i]==1 && !visited[i]) {
                dfs(computers, i);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}})); //2
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}})); //1
    }
}
