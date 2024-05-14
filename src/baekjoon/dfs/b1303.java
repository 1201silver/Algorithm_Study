package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1303 {

    private static int[] dx = {0, 0, -1, 1}; /* 상 하 좌 우 */
    private static int[] dy = {-1, 1, 0, 0};

    private static int n;
    private static int m; /* 세로 */

    private static char[][] map;
    private static boolean[][] visit;

    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[m][n];
        visit = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            String line = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int sum = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                cnt = 0;
                if(map[i][j] == 'W' && !visit[i][j]) {
                    dfs(i, j, 'W');
                }
                sum += (int) Math.pow(cnt, 2);
            }
        }
        sb.append(sum).append(" ");

        sum = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                cnt = 0;
                if(map[i][j] == 'B' && !visit[i][j]) {
                    dfs(i, j, 'B');
                }
                sum += (int) Math.pow(cnt, 2);
            }
        }
        sb.append(sum).append(" ");

        System.out.print(sb);
    }

    static void dfs(int x, int y, char c) {
        visit[x][y] = true;
        cnt++;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < m && ny < n) {
                if(map[nx][ny] == c && !visit[nx][ny]) {
                    dfs(nx, ny, c);
                }
            }
        }
    }
}
