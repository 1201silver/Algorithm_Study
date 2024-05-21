package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class b2583 {

    private static int[] dx = {0, 0, -1, 1}; // 좌 우 // n
    private static int[] dy = {1, -1, 0, 0}; // 상 하 // m

    private static int m, n;
    private static int[][] grid;
    private static boolean[][] visit;
    private static ArrayList<Integer> list;
    private static int area;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        grid = new int[m][n];
        visit = new boolean[m][n];
        list = new ArrayList<>();

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken()); // x
            int b1 = Integer.parseInt(st.nextToken()); // y
            int a2 = Integer.parseInt(st.nextToken());
            int b2 = Integer.parseInt(st.nextToken());

            draw(a1, b1, a2, b2);
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0 && !visit[i][j]) {
                    area = 0;
                    dfs(i, j);
                    list.add(area);
                }
            }
        }

        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for(int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(" ");
        }
        System.out.print(sb);
    }

    static void draw(int x1, int y1, int x2, int y2) {
        for(int i = y1; i < y2; i++) {
            for(int j = x1; j < x2; j++) {
                grid[i][j] = 1;
            }
        }
    }

    static void dfs(int a, int b) {
        visit[a][b] = true;
        area++;

        for(int i = 0; i < 4; i++) {
            int ny = a + dy[i];
            int nx = b + dx[i];

            if(ny >= 0 && nx >= 0 && ny < m && nx < n) {
                if(grid[ny][nx] == 0 && !visit[ny][nx]){
                    dfs(ny, nx);
                }
            }
        }
    }
}
