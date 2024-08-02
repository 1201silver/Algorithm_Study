package baekjoon.workbook.algoType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class b1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> book = new HashMap<>();
        int max = 0;
        for(int i = 0; i < n; i++) {
            String title = br.readLine();
            if(!book.containsKey(title)) {
                book.put(title, 1);
            } else {
                book.put(title, book.get(title) + 1);
            }

            if(max < book.get(title)) {
                max = book.get(title);
            }
        }

        ArrayList<String> list = new ArrayList<>();
        for(String key : book.keySet()) {
            if(max == book.get(key)) {
                list.add(key);
            }
        }
        Collections.sort(list);
        System.out.print(list.get(0));
    }
}
