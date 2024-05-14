package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1987 {

    private static int[] dx = {0, 0, -1, 1}; /* 상 하 좌 우 */
    private static int[] dy = {-1, 1, 0, 0};

    private static int r; /* 세로 */
    private static int c;

    private static char[][] board;
    private static boolean[] visit;
//    private static Queue<Character> queue;

    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];
        visit = new boolean[26];
//        queue = new LinkedList<>();

        for(int i = 0; i < r; i++) {
            String line = br.readLine();
            for(int j = 0; j < c; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        max = 0;
        dfs(0, 0, 1);
        System.out.print(max);
    }

    static void dfs(int x, int y, int cnt) {
//        queue.add(board[x][y]);
        visit[board[x][y] - 'A'] = true;
        max = Math.max(max, cnt);

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < r && ny < c) {
//                if(!queue.contains(board[nx][ny])) {
                if(!visit[board[nx][ny] - 'A']) {
                    dfs(nx, ny, cnt + 1);
//                    queue.poll();
                }
            }
        }
        visit[board[x][y] - 'A'] = false; // 다른 DFS 탐색 위한 초기화
    }
}
