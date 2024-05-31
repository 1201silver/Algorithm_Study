package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14716 {

    private static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1}; // 상 하 좌 우 상좌 상우 하좌 하우
    private static int[] dy = {1, -1, 0, 0, 1, 1, -1, -1}; // 상 하 좌 우 상좌 상우 하좌 하우

    private static int m, n;
    private static int[][] banner;
    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        banner = new int[m][n];
        visit = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                banner[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visit[i][j] && banner[i][j] == 1) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        System.out.print(cnt);
    }

    static void dfs(int a, int b) {
        visit[a][b] = true;

        for(int i = 0; i < 8; i++) {
            int ny = a + dy[i];
            int nx = b + dx[i];

            if(ny >= 0 && nx >= 0 && ny < m && nx < n) {
                if(!visit[ny][nx] && banner[ny][nx] == 1) {
                    dfs(ny, nx);
                }
            }
        }
    }
}
