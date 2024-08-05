package baekjoon.workbook.algoType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2606 {

    private static int com;

    private static int[][] graph;
    private static boolean[] visit;

    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        com = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        graph = new int[com + 1][com + 1];
        visit = new boolean[com + 1];

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = graph[b][a] = 1;
        }

        dfs(1);
        System.out.println(cnt - 1);
    }

    static void dfs(int n) {
        visit[n] = true;
        cnt++;

        for(int i = 1; i <= com; i++) {
            if(graph[n][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }
}
