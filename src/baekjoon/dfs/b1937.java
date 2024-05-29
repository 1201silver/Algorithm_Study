package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1937 {

    private static int[] dx = {0, 0, -1, 1}; // 상 하 좌 우
    private static int[] dy = {1, -1, 0, 0}; // 상 하 좌 우

    private static int[][] forest;
    private static int[][] memo;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        forest = new int[n][n];
        memo = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        int res = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                max = dfs(i, j);
                res = Math.max(res, max);
            }
        }

        System.out.print(res);
    }

    static int dfs(int a, int b) {
        if(memo[a][b] != 0) {
            return memo[a][b];

        } else {
            memo[a][b] = 1;

            for(int i = 0; i < 4; i++) {
                int ny = a + dy[i];
                int nx = b + dx[i];

                if(ny >= 0 && nx >= 0 && ny < n && nx < n) {
                    if(forest[a][b] < forest[ny][nx]) {
                        memo[a][b] = Math.max(memo[a][b], dfs(ny, nx) + 1);
                    }
                }
            }
            return memo[a][b];
        }
    }
}
