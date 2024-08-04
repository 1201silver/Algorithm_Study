package baekjoon.workbook.algoType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int digit = 0;
        int cnt = 1;
        int num = 10;

        for(int i = 1; i <= n; i++) {
            if(i % num == 0) {
                cnt++; // 자릿수 증가
                num *= 10;
            }
            digit += cnt;
        }
        System.out.print(digit);
    }
}
