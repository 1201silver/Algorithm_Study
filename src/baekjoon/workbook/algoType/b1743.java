package baekjoon.workbook.algoType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1743 {

    private static int[] dy = {1, -1, 0, 0}; /* 상하좌우 */
    private static int[] dx = {0, 0, -1, 1};

    private static int n;
    private static int m;

    private static int[][] map;
    private static boolean[][] visit;

    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m];

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a - 1][b - 1] = 1;
        }

        int max = -1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visit[i][j] && map[i][j] == 1) {
                    cnt = 0;
                    dfs(i, j);
                    max = Math.max(cnt, max);
                }
            }
        }
        System.out.println(max);
    }

    static void dfs(int y, int x) {
        visit[y][x] = true;
        cnt++;

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= 0 && nx >= 0 && ny < n && nx < m) {
                if(!visit[ny][nx] && map[ny][nx] == 1) {
                    dfs(ny, nx);
                }
            }
        }
    }
}
