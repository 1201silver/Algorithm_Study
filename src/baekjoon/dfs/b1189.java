package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1189 {

    private static int[] dx = {0, 0, -1, 1}; // 좌, 우 // c
    private static int[] dy = {1, -1, 0, 0}; // 상, 하 // r

    private static int r, c, k;
    private static char[][] map;
    private static boolean[][] visit;
    private static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visit = new boolean[r][c];

        for(int i = 0; i < r; i++) {
            String line = br.readLine();
            for(int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        dfs(r - 1, 0, 0);
        System.out.print(res);
    }

    static void dfs(int a, int b, int cnt) {
        visit[a][b] = true;
        cnt++;
        if(a == 0 && b == c - 1) {
            if(cnt == k) {
                res++;
            }
            return;
        }

        for(int i = 0; i < 4; i++) {
            int ny = a + dy[i]; // r
            int nx = b + dx[i]; // c

            if(nx >= 0 && ny >= 0 && nx < c && ny < r) {
                if(map[ny][nx] == '.' && !visit[ny][nx]) {
                    dfs(ny, nx, cnt);
                    visit[ny][nx] = false;
                }
//                visit[ny][nx] = false;
            }
        }
    }
}
