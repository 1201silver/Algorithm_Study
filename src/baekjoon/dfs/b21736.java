package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b21736 {

    private static int[] dx = {0, 0, -1, 1}; /* 상 하 좌 우 */
    private static int[] dy = {-1, 1, 0, 0};

    private static int n;
    private static int m;
    private static char[][] map;
    private static boolean[][] visit;

    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visit = new boolean[n][m];

        int ix = 0, iy = 0;
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++) {
                if(line.charAt(j) == 'I') {
                    ix = i;
                    iy = j;
                }
                map[i][j] = line.charAt(j);
            }
        }
        dfs(ix, iy);

        if(cnt == 0) {
            System.out.print("TT");
        }
        else {
            System.out.print(cnt);
        }
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;
        if(map[x][y] == 'P') {
            cnt++;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if(map[nx][ny] != 'X' && !visit[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
