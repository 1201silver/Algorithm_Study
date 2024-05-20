package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class b24480 {

    private static int n;
    private static ArrayList<Integer>[] graph;
    private static int[] order;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        order = new int[n + 1];

        for(int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i = 1; i < n + 1; i++) {
            /* 미리 정렬 후 dfs 호출 -> 메모리 감소, 시간 늘어남
            * dfs에서 정렬 -> 메모리 증가, 시간 감소 */
            Collections.sort(graph[i], Collections.reverseOrder());
        }

        cnt = 1;
        dfs(r);

        for(int i = 1; i < n + 1; i++) {
            sb.append(order[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int v) {
        order[v] = cnt++;
        for(int i : graph[v]) {
            if(order[i] == 0) {
                dfs(i);
            }
        }
    }
}
