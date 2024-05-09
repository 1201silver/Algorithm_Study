package baekjoon.bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b4963 {

    private static BufferedReader br;
    private static StringTokenizer st;

    private static int w, h;

    private static int[][] map;
    private static boolean[][] visit;

    private static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1}; /* 상 하 좌 우, 상좌, 상우, 하좌, 하우*/
    private static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) break;

            map = new int[h][w];
            visit = new boolean[h][w];
            setMap(w, h);

            int cnt = 0;
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(map[i][j] == 1 && !visit[i][j]) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt + "\n");
        }
        System.out.print(sb);
    }

    static void setMap(int w, int h) throws IOException {
        for(int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();

        visit[x][y] = true;
        queue.add(new Point(x, y));

        while(!queue.isEmpty()) {
            Point point = queue.poll();

            for(int i = 0; i < 8; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < h && ny < w) {
                    if(!visit[nx][ny] && map[nx][ny] == 1) {
                        visit[nx][ny] = true;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
    }
}
