package baekjoon.workbook.algoType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class b2667 {

    private static int[] dy = {1, -1, 0, 0}; /* 상하좌우 */
    private static int[] dx = {0, 0, -1, 1};

    private static int n;

    private static int[][] map;
    private static boolean[][] visit;

    private static int area;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visit = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        int cnt = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visit[i][j] && map[i][j] == 1) {
                    area = 0;
                    dfs(i, j);
                    arr.add(area);
                    cnt++;
                }
            }
        }
        sb.append(cnt).append("\n");
        Collections.sort(arr);
        for(int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i)).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int y, int x) {
        visit[y][x] = true;
        area++;

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= 0 && nx >= 0 && ny < n && nx < n) {
                if(!visit[ny][nx] && map[ny][nx] == 1) {
                    dfs(ny, nx);
                }
            }
        }
    }
}
