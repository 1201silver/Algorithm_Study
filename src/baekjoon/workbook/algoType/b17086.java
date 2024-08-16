package baekjoon.workbook.algoType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b17086 {

    private static int[] dy = {1, -1, 0, 0, 1, 1, -1, -1}; /* 상하좌우 상좌 상우 하좌 하우*/
    private static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};

    private static int n;
    private static int m;

    private static int[][] space;
    private static boolean[][] visit;

    private static int max = -1;

    static class Point {
        int y, x, cnt;

        public Point(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        space = new int[n][m];
        visit = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(space[i][j] != 1) {
                    visit = new boolean[n][m];
                    bfs(i, j);
                }
            }
        }
        System.out.print(max);
    }

    static void bfs(int a, int b) {
        Queue<Point> queue = new LinkedList<>();

        visit[a][b] = true;
        queue.add(new Point(a, b, 0));

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if(space[point.y][point.x] == 1) {
                max = Math.max(max, point.cnt);
                return;
            }

            for(int i = 0; i < 8; i++) {
                int ny = point.y + dy[i];
                int nx = point.x + dx[i];

                if(ny >= 0 && nx >= 0 && ny < n && nx < m) {
                    if(!visit[ny][nx]) {
                        visit[ny][nx] = true;
                        queue.add(new Point(ny, nx, point.cnt + 1));
                    }
                }
            }
        }
    }
}
