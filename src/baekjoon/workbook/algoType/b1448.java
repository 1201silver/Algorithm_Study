package baekjoon.workbook.algoType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b1448 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int i = n - 1;
        while(i > 1) {
            if(arr[i] < arr[i - 1] + arr[i - 2]) {
                System.out.print(arr[i] + arr[i - 1] + arr[i - 2]);
                return;
            }
            i--;
        }
        System.out.print(-1);
    }
}
