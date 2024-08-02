package baekjoon.workbook.algoType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* GCD(최대공약수) */
public class b9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for(int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            long sum = 0; /* int 틀림 */
            for(int j = 0; j < n - 1; j++) {
                for(int k = j + 1; k < n; k++) {
                    sum += getGcd(arr[j], arr[k]);
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }

    static long getGcd(int a, int b) {
        if(b != 0) {
            return getGcd(b, a % b);
        }
        return a;
    }
}
