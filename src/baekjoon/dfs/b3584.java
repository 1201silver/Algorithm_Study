package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b3584 {

//    private static ArrayList<Integer>[] arr;
    private static int[] arr; // 부모 없는 노트 루트 밖에 없음, ArrayList 쓸 필요 X
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            arr = new int[n + 1];
            visit = new boolean[n + 1];

            for(int k = 0; k < n - 1; k++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                arr[b] = a; // a가 b의 부모
            }

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(getParent(a, b)).append("\n");
        }
        System.out.print(sb);
    }

    static int getParent(int a, int b) {
        while(a > 0) { // arr[루트] = 0 (배열 초기화 상태)
            visit[a] = true;
            a = arr[a];
        }

        while(b > 0) {
            if(visit[b]) {
                break;
            }
            b = arr[b];
        }
        return b;
    }

//    static int getParent(int a, int b) {
//        visit[a] = true;
//        while(!arr[a].isEmpty()) {
//            a = arr[a].get(0);
//            visit[a] = true;
//        }
//
//        while(!arr[b].isEmpty()) {
//            if(visit[b]) {
//                break;
//            }
//            b = arr[b].get(0);
//        }
//
//        return b;
//    }
}
