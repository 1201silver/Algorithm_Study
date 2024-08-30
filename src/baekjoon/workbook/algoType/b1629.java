package baekjoon.workbook.algoType;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class b1629 { /* 모듈러 연산 */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.print(pow(A, B, C));
    }

    static long pow(long a, long b, long c) {
        if(b == 1) {
            return a % c;
        }

        long tmp = pow(a, b / 2, c);

        if(b % 2 == 1) {
            return ((tmp * tmp % c) * (a % c)) % c;
        } else {
            return tmp * tmp % c;
        }
    }
}
