package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b13565 {

    private static int[] dx = {0, 0, -1, 1}; // 좌 우 // n
    private static int[] dy = {1, -1, 0, 0}; // 상 하 // m

    private static int m, n;
    private static int[][] grid;
    private static boolean[][] visit;

    private static boolean res = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        grid = new int[m][n];
        visit = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            String line = br.readLine();
            for(int j = 0; j < n; j++) {
                grid[i][j] = line.charAt(j) - '0';
            }
        }

        for(int i = 0; i < n; i++) {
            if(grid[0][i] == 0) { // 이전에 방문 되어 있으면 시작 못함 -> visit 체크 X
                dfs(0, i);
            }
        }

        if(!res) {
            System.out.print("NO");
        } else {
            System.out.print("YES");
        }
    }

    static void dfs(int a, int b) {
        visit[a][b] = true;

        if(a == m - 1) {
            res = true;
            return;
        }

        for(int i = 0; i < 4; i++) {
            int ny = a + dy[i];
            int nx = b + dx[i];

            if(ny >= 0 && nx >= 0 && ny < m && nx < n) {
                if(grid[ny][nx] == 0 && !visit[ny][nx]) {
                    dfs(ny, nx);
                }
            }
        }
    }
}
