package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b15681 {

    private static ArrayList<Integer>[] tree;
    private static int[] memo;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int root = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        tree = new ArrayList[n + 1];
        memo = new int[n + 1];
        visit = new boolean[n + 1];

        for(int i = 1; i < n + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree[u].add(v);
            tree[v].add(u);
        }

        dfs(root);

        for(int i = 0; i < q; i++) {
            int sub = Integer.parseInt(br.readLine());
            sb.append(memo[sub]).append("\n");
        }
        System.out.print(sb);
    }

    static int dfs(int n) {
        visit[n] = true;
        memo[n] = 1;

        for(int child : tree[n]) {
            if(!visit[child]) {
                memo[n] += dfs(child);
            }
        }
        return memo[n];
    }
}
