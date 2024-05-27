package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b1967 {

    private static ArrayList<Node>[] tree;
    private static boolean[] visit;
    private static int max;

    private static class Node {
        int node;
        int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];

        for (int i = 1; i < n + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[a].add(new Node(b, weight));
            tree[b].add(new Node(a, weight));
        }

        for(int i = 1; i < n + 1; i++) {
            visit = new boolean[n + 1];
            dfs(i, 0);
        }
        System.out.print(max);
    }

    static void dfs(int n, int sum) {
        visit[n] = true;
        for(Node node : tree[n]) {
            if(!visit[node.node]) {
                dfs(node.node, sum + node.weight);
            }
        }
        max = Math.max(max, sum);
    }
}
