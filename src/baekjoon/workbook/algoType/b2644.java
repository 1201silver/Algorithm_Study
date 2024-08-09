package baekjoon.workbook.algoType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b2644 {

    private static ArrayList<Integer>[] arr;
    private static boolean visit[];

    private static int n;
    private static int a;
    private static int b;
    private static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new ArrayList[n + 1];
        visit = new boolean[n + 1];

        for(int i = 0; i < n + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x].add(y);
            arr[y].add(x);
        }

        dfs(a, 0);
        if(res == 0) System.out.println(-1);
        else System.out.println(res);
    }

    static void dfs(int num, int cnt) {
        visit[num] = true;

        if(num == b) {
            res = cnt;
            return;
        }

        for(int i = 0; i < arr[num].size(); i++) {
            int tmp = arr[num].get(i);
            if(!visit[tmp]) {
                dfs(tmp, cnt + 1);
            }
        }
    }
}
