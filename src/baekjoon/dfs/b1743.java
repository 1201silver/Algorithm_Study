package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1743 {

    private static int[] dx = {0, 0, -1, 1}; // 좌, 우 // m
    private static int[] dy = {1, -1, 0, 0}; // 상, 하 // n

    private static int n, m;

    private static int[][] food;
    private static boolean[][] visit;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        food = new int[n][m];
        visit = new boolean[n][m];

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            food[a][b] = 1;
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(food[i][j] == 1 && !visit[i][j]) {
                    cnt = 0;
                    dfs(i, j);
                    if(cnt > max) {
                        max = cnt;
                    }
                }
            }
        }
        System.out.print(max);
    }

    static void dfs(int a, int b) {
        visit[a][b] = true;

        if(food[a][b] == 1) {
            cnt++;
        }

        for(int i = 0; i < 4; i++) {
            int ny = a + dy[i];
            int nx = b + dx[i];

            if(ny >= 0 && nx >= 0 && ny < n && nx < m) {
                if(food[ny][nx] == 1 && !visit[ny][nx]) {
                    dfs(ny, nx);
                }
            }
        }
    }
}
