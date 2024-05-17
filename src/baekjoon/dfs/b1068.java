package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b1068 {

    private static ArrayList<Integer>[] tree;
    private static boolean[] visit;
    private static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        visit = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int root = 0;
        for(int i = 0; i < n; i++) {
            int node = Integer.parseInt(st.nextToken());
            if(node == -1) {
                root = i;
            } else {
                tree[node].add(i);
            }
        }

        int delete = Integer.parseInt(br.readLine());
        if(delete == root) {
            System.out.println(0);
        } else {
            visit[delete] = true;
            res = 0;
            dfs(root);
            System.out.print(res);
        }
    }

    static void dfs(int n) {
        int cnt = 0;
        visit[n] = true;

        for(int child : tree[n]) {
            if(!visit[child]) {
                dfs(child);
                cnt++;
            }
        }

        if(cnt == 0) {
            res++;
        }
    }
}
