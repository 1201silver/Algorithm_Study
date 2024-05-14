package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1926 {

    private static int[] dx = {0, 0, -1, 1}; /* 상 하 좌 우 */
    private static int[] dy = {-1, 1, 0, 0};

    private static int n; /* 세로 */
    private static int m;
    private static int[][] picture;
    private static boolean[][] visit;

    private static int area;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        picture = new int[n][m];
        visit = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                picture[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(picture[i][j] == 1 && !visit[i][j]) {
                    area = 0;
                    cnt++;
                    dfs(i, j);

                    if(area > max) {
                        max = area;
                    }
                }
            }
        }
        System.out.print(cnt + "\n" + max);
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;
        area++;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if(picture[nx][ny] == 1 && !visit[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
