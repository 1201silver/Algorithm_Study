package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b9466 {

    private static int[] student;
    private static boolean[] team;
    private static boolean[] visit;

    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            student = new int[n + 1];
            team = new boolean[n + 1];
            visit = new boolean[n + 1];

            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < n + 1; j++) {
                student[j] = Integer.parseInt(st.nextToken());
            }

            cnt = 0;
            for(int j = 1; j < n + 1; j++) {
                if(!team[j]) {
                    dfs(j);
                }
            }
            sb.append(n - cnt).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int n) {
        if(visit[n]) {
            team[n] = true;
            cnt++;
        } else {
            visit[n] = true;
        }

        int next = student[n];
        if(!team[next]) {
            dfs(next);
        }

        team[n] = true; /* 없으면 시간 초과, 사이클에 들어가지 않았다면 앞으로 검사해도 의미 X, team 처리 하되 cnt는 반영 X */
        visit[n] = false;
    }
}
