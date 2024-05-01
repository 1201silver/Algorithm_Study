package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2606 {

    private static int n; /* vertex */
    private static int[][] graph;
    private static boolean[] visited;

    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        StringTokenizer st;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = graph[b][a] = 1;
        }

        dfs(1);
        System.out.println(cnt - 1);
    }

    static void dfs(int v) {
        visited[v] = true;
        cnt++;

        for(int i = 1; i < n + 1; i++) {
            if(graph[v][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}