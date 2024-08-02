package baekjoon.workbook.algoType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b15649 {

    private static StringBuilder sb = new StringBuilder();

    private static int n;
    private static int m;

    private static int[] arr;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visit = new boolean[n + 1];

        dfs(0);

        System.out.print(sb);
    }

    static void dfs(int depth) {
        if(depth == m) {
            for(int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i < n + 1; i++) {
            if(!visit[i]) {
                visit[i] = true;
                arr[depth] = i;
                dfs(depth + 1);
                visit[i] = false; /* if문 밖에 하면 틀림 */
            }
        }
//        System.out.println("Dfs end");
    }
}
