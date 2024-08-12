package baekjoon.workbook.algoType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b11729 {

    private static StringBuilder sb = new StringBuilder();
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        hanoi(n, 1, 2, 3);
        System.out.println(cnt);
        System.out.print(sb);
    }

    static void hanoi(int n, int from, int mid, int to) { /* A(from) B(mid) C(to) */
        if(n == 1) {
            cnt++;
            sb.append(from + " " + to).append("\n");
            return;
        }

        cnt++;
        hanoi(n - 1, from, to, mid);
        sb.append(from + " " + to).append("\n");
        hanoi(n - 1, mid, from, to);
    }
}
