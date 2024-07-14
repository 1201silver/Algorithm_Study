package baekjoon.workbook.algoType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int min = 100;
        int sum = 0;
        for(int i = 0; i < 7; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num % 2 != 0) {
                sum += num;
                if(num < min) {
                    min = num;
                }
            }
        }

        if(min == 100) {
            System.out.print(-1);
        } else {
            System.out.print(sum + "\n" + min);
        }
    }
}
