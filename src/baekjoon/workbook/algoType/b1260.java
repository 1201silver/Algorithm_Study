package baekjoon.workbook.algoType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1260 {

    private static StringBuilder sb = new StringBuilder();;

    private static int n;
    private static int m;

    private static int[][] graph;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][n + 1];
        visit = new boolean[n + 1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = graph[b][a] = 1;
        }

        dfs(v);
        sb.append("\n");
        visit = new boolean[n + 1];
        bfs(v);

        System.out.println(sb);
    }

    static void dfs(int num) {
        visit[num] = true;
        sb.append(num).append(" ");

        for(int i = 1; i <= n; i++) {
            if(graph[num][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(num);
        visit[num] = true;

        while(!queue.isEmpty()) {
            int tmp =  queue.poll();
            sb.append(tmp).append(" ");
            for(int i = 1; i <= n; i++) {
                if(graph[tmp][i] == 1 && !visit[i]) {
                    visit[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
