package baekjoon.workbook.algoType;
/* https://www.acmicpc.net/workbook/view/7893 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b10797 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for(int i = 0; i < 5; i++) {
            int car = Integer.parseInt(st.nextToken());
            if(car == num) cnt++;
        }
        System.out.println(cnt);
    }
}
