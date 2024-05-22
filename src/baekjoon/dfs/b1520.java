package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1520 {

    private static int[] dx = {0, 0, -1, 1}; // 좌, 우
    private static int[] dy = {-1, 1, 0, 0}; // 상, 하

    private static int m, n;
    private static int[][] map;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        dp = new int[m][n];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j ++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.print(dfs(0, 0));
    }

    static int dfs(int a, int b) {
        if(a == m - 1 && b == n - 1) { // 도착 지점
           return 1;
        }

        if(dp[a][b] == -1) { // 방문한 적 X
            dp[a][b] = 0;

            for(int i = 0; i < 4; i++) {
                int ny = a + dy[i];
                int nx = b + dx[i];

                if(ny >= 0 && nx >= 0 && ny < m && nx < n) {
                    if(map[ny][nx] < map[a][b]) {
                        dp[a][b] += dfs(ny, nx);
                    }
                }
            }
        }
        return dp[a][b];
    }
}
