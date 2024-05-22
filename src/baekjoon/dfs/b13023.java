package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b13023 {

    private static ArrayList<Integer>[] arr;
    private static boolean[] visit;
    private static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n];
        visit = new boolean[n];

        for(int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        for(int i = 0; i < n; i++) {
            if(res == 1) break;
            dfs(i, 1);
        }
        System.out.print(res);
    }

    static void dfs(int v, int cnt) {
        if(cnt == 5) {
            res = 1;
            return;
        }

        visit[v] = true;
        for(int n : arr[v]) {
            if(!visit[n]) {
                dfs(n, cnt + 1);
            }
        }
        visit[v] = false;
    }
}
