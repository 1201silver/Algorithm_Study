package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b1167 {

    private static ArrayList<Node>[] arr;
    private static boolean visit[];

    private static int maxIdx;
    private static int max = 0;

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

        int v = Integer.parseInt(br.readLine());

        arr = new ArrayList[v + 1];
        for(int i = 1; i < v + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 1; i < v + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            while(true) {
                int node = Integer.parseInt(st.nextToken());
                if(node == -1) break;
                int weight = Integer.parseInt(st.nextToken());

                arr[n].add(new Node(node, weight));
                arr[node].add(new Node(n, weight));
            }
        }

        visit = new boolean[v + 1];
        dfs(1, 0); // 임의의 노드

        visit = new boolean[v + 1];
        dfs(maxIdx, 0);

        System.out.print(max);
    }

    static void dfs(int n, int sum) {
        visit[n] = true;

        if(sum > max) {
            max = sum;
            maxIdx = n;
        }

        for(Node node : arr[n]) {
            if(!visit[node.node]) {
                dfs(node.node, sum + node.weight);
            }
        }
    }
}

/* 참고
* https://moonsbeen.tistory.com/101
* https://kkmdailylog.tistory.com/entry/AlgorithmJava%EB%B0%B1%EC%A4%80-1167-%ED%8A%B8%EB%A6%AC%EC%9D%98-%EC%A7%80%EB%A6%84
*/