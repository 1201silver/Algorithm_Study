package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2573 {

    private static int[] dx = {0, 0, -1, 1}; // 상 하 좌 우
    private static int[] dy = {1, -1, 0, 0}; // 상 하 좌 우

    private static int n, m;
    private static int[][] grid, sea;
    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while(true) {
            sea = new int[n][m];
            visit = new boolean[n][m];

            int cnt = getCnt();
            if(cnt == 0) {
                System.out.print(0);
                break;
            } else if(cnt >= 2) {
                System.out.print(year);
                break;
            }
            year++;
            getMelt();
        }
    }

    static int getCnt() {
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] != 0 && !visit[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void dfs(int a, int b) {
        visit[a][b] = true;

        for(int i = 0; i < 4; i++) {
            int ny = a + dy[i];
            int nx = b + dx[i];

            if(ny >= 0 && nx >= 0 && ny < n && nx < m) {
                if(grid[ny][nx] != 0 && !visit[ny][nx]) {
                    dfs(ny, nx);
                }
            }

            if(grid[ny][nx] == 0) {
                sea[a][b]++;
            }
        }
    }

    static void getMelt() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] != 0) {
                    grid[i][j] -= sea[i][j];
                    if(grid[i][j] < 0) {
                        grid[i][j] = 0;
                    }
                }
            }
        }
    }
}
