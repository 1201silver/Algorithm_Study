package baekjoon.workbook.algoType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class b1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();

        HashMap<Character, Integer> alph = new HashMap<>();

        for(int i = 0; i < str.length(); i++) {
            if(alph.containsKey(str.charAt(i))) {
                alph.put(str.charAt(i), alph.get(str.charAt(i)) + 1);
            } else {
                alph.put(str.charAt(i), 1);
            }
        }

        int max = 0;
        char res = ' ';
        for(Character key : alph.keySet()) {
            int val = alph.get(key);
            if(max < val) {
                max = val;
                res = key;
            } else if(max == val) {
                res = '?';
            }
        }
        System.out.print(res);
    }
}
