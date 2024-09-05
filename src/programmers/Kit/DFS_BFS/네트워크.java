package programmers.Kit.DFS_BFS;

public class 네트워크 {

    static boolean[] visit;

    public int solution(int n, int[][] computers) {
        int answer = 0;

        int com = computers.length;
        visit = new boolean[com];

        for(int i = 0; i < com; i++) {
            if(!visit[i]) {
                dfs(computers, i);
                answer++;
            }
        }
        return answer;
    }

    public void dfs(int[][] computers, int num) {
        visit[num] = true;

        for(int i = 0; i < computers.length; i++) {
            if(computers[num][i] == 1 && !visit[i]) {
                dfs(computers, i);
            }
        }
    }
}
