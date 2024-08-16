package baekjoon.workbook.algoType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2178 { /* dfs 시간초과 */

    private static int[] dy = {1, -1, 0, 0}; /* 상하좌우 */
    private static int[] dx = {0, 0, -1, 1};

    private static int n;
    private static int m;

    private static int[][] map;
    private static boolean[][] visit;
    private static int[][] memo;

    static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m];
        memo = new int[n][m];

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

//        dfs(0, 0, 1);
        bfs(0, 0);
        System.out.print(memo[n - 1][m - 1] + 1);
    }

    static void bfs(int y, int x) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(y, x));
        visit[y][x] = true;

        while(!queue.isEmpty()) {
            Point point = queue.poll();

            for(int i = 0; i < 4; i++) {
                int ny = point.y + dy[i];
                int nx = point.x + dx[i];

                if(ny >= 0 && nx >= 0 && ny < n && nx < m) {
                    if(!visit[ny][nx] && map[ny][nx] == 1) {
                        queue.add(new Point(ny, nx));
                        visit[ny][nx] = true;
                        memo[ny][nx] = memo[point.y][point.x] + 1;
                    }
                }
            }
        }
    }

    /*
    static void dfs(int y, int x, int cnt) {
        visit[y][x] = true;

        if(y == n - 1 && x == m - 1) {
            min = Math.min(cnt, min);
        }

        for(int i = 0 ; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= 0 && nx >= 0 && ny < n && nx < m) {
                if(!visit[ny][nx] && map[ny][nx] == 1) {
                    dfs(ny, nx, cnt + 1);
                    visit[ny][nx] = false;
                }
            }
        }
    } */
}
