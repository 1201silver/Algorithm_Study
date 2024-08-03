package baekjoon.workbook.algoType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b15650 {

    private static StringBuilder sb = new StringBuilder();

    private static int n;
    private static int m;

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        dfs(1, 0);
        System.out.print(sb);
    }

    static void dfs(int idx, int depth) {
        if(depth == m) {
            for(int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = idx; i < n + 1; i++) {
            arr[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}
