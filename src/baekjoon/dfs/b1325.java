package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b1325 { // 시간초과

    private static ArrayList<Integer>[] computer;
    private static boolean[] visit;
    private static int[] cnt;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        computer = new ArrayList[n + 1];
        cnt = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            computer[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            computer[a].add(b);
        }

        for (int i = 1; i < n + 1; i++) {
            visit = new boolean[n + 1];
            dfs(i);
        }

        int max = 0;
        for(int i = 1; i < n + 1; i++) {
            if(cnt[i] > max) {
                max = cnt[i];
            }
        }

        for(int i = 1; i < n + 1; i++) {
            if(cnt[i] == max) {
                sb.append(i + " ");
            }
        }
        System.out.println(sb);
    }

    static void dfs(int v) {
        visit[v] = true;

        for(int num : computer[v]) {
            if(!visit[num]) {
                cnt[num]++;
                dfs(num);
            }
        }
    }
}
