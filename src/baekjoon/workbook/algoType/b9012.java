package baekjoon.workbook.algoType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Stack<Character> stack;

        for(int i = 0; i < n; i++) {
            stack = new Stack<>();
            String str = br.readLine();

            for(int j = 0; j < str.length(); j++) {
                if(stack.isEmpty()) {
                    stack.push(str.charAt(j));
                } else {
                    if(stack.peek() == '(' && str.charAt(j) == ')') {
                        stack.pop();
                    } else {
                        stack.push(str.charAt(j));
                    }
                }
            }

            if(stack.isEmpty()) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }
}
