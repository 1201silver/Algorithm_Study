package baekjoon.workbook.algoType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Character> stack;
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            stack = new Stack<>();
            String str = br.readLine();

            for(int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if(stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if(c == stack.peek()) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }
            if(stack.isEmpty()) cnt++;
        }
        System.out.print(cnt);
    }
}
