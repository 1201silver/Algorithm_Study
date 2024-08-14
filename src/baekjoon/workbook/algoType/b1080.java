package baekjoon.workbook.algoType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1080 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] A = new char[n][m];
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < m; j++) {
                A[i][j] = str.charAt(j);
            }
        }

        char[][] B = new char[n][m];
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < m; j++) {
                B[i][j] = str.charAt(j);
            }
        }

        int cnt = 0;
        for(int i = 0; i < n - 2; i++) {
            for(int j = 0; j < m - 2; j++) {
                if(A[i][j] == B[i][j]) {
                    continue;
                }

                for(int k = i; k < i + 3; k++) {
                    for(int r = j; r < j + 3; r++) {
                        if(A[k][r] == '0') {
                            A[k][r] = '1';
                        } else {
                            A[k][r] = '0';
                        }

                    }
                }
                cnt++;
            }
        }

        boolean flag = true;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(A[i][j] != B[i][j]) {
                    flag = false;
                }
            }
        }

        if(flag) System.out.println(cnt);
        else System.out.print(-1);
    }
}
