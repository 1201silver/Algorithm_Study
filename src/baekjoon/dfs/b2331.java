package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b2331 {

    private static int p;
    private static int idx;
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        list.add(a);

        dfs(a);

        System.out.println(idx);
    }

    static void dfs(int num) {
        int sum = 0;

        while(num > 0) {
            sum += (int) Math.pow((num % 10), p);
            num /= 10;
        }

        if(!list.contains(sum)) {
            list.add(sum);
            dfs(sum);
        } else {
            idx = list.indexOf(sum);
            return;
        }
    }
}
