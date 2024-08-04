package baekjoon.workbook.algoType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1463 {

    private static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        memo = new int[n + 1];
        System.out.print(dfs(n));
    }

    static int dfs(int n) {
        if(n == 1) {
            return 0;
        }

        if(memo[n] == 0) {
            if(n % 2 == 0 && n % 3 == 0) {
                memo[n] = Math.min(dfs(n / 2), Math.min(dfs(n / 3), dfs(n - 1))) + 1;
            } else if (n % 2 == 0) {
                memo[n] = Math.min(dfs(n / 2), dfs(n - 1)) + 1;
            } else if(n % 3 == 0) {
                memo[n] = Math.min(dfs(n / 3), dfs(n - 1)) + 1;
            } else {
                memo[n] = dfs(n - 1) + 1;
            }
        }
        return memo[n];
    }
}
