package baekjoon.workbook.algoType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int pre = 0;
        int add = 0;
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++) {
            int ans = Integer.parseInt(st.nextToken());
            if(ans == 1) {
                if(pre == 0) {
                    sum += 1;
                    add = 0;
                } else {
                    add++;
                    sum = sum + 1 + add;
                }
            }
            pre = ans;
        }
        System.out.print(sum);
    }
}
