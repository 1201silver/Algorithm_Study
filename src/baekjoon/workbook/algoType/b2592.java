package baekjoon.workbook.algoType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class b2592 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap <Integer, Integer> number = new HashMap<>();

        int sum = 0;
        for(int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            sum += n;

            if(number.containsKey(n)) {
                number.put(n, number.get(n) + 1);
            } else {
                number.put(n, 1);
            }
        }

        int max = 0;
        int mode = 0;
        for(int key : number.keySet()) {
            if(max < number.get(key)) {
                max = number.get(key);
                mode = key;
            }
        }
        System.out.print(sum / 10 + "\n" + mode);
    }
}
