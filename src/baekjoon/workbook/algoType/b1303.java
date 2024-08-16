package baekjoon.workbook.algoType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1303 {

    private static int[] dy = {1, -1, 0, 0}; /* 상하좌우 */
    private static int[] dx = {0, 0, -1, 1};

    private static int n, m;
    private static char[][] map;
    private static boolean[][] visit;

    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[m][n];
        visit = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            String str = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int sum = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 'W' && !visit[i][j]) {
                    cnt = 0;
                    dfs(i, j, 'W');
                    sum += Math.pow(cnt, 2);
                }
            }
        }
        System.out.print(sum + " ");

        sum = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 'B' && !visit[i][j]) {
                    cnt = 0;
                    dfs(i, j, 'B');
                    sum += Math.pow(cnt, 2);
                }
            }
        }
        System.out.print(sum);
    }

    static void dfs(int y, int x, char c) {
        visit[y][x] = true;
        cnt++;

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= 0 && nx >= 0 && ny < m && nx < n) {
                if(!visit[ny][nx] && map[ny][nx] == c) {
                    dfs(ny, nx, c);
                }
            }
        }
    }
}
