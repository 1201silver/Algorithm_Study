package baekjoon.workbook.algoType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int cnt = 1;
        while(B != A) {
            if(B < A) {
                System.out.println(-1);
                return;
            }

            String tmp = String.valueOf(B);
            if(tmp.charAt(tmp.length() - 1) == '1') {
                B = Integer.parseInt(tmp.substring(0, tmp.length() - 1));
            } else if(B % 2 == 0){
                B /= 2;
            } else {
                System.out.println(-1);
                return;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
