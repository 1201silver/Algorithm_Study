package baekjoon.workbook.algoType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();

        int multi = 1;
        int sum = 0;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(') {
                stack.push(c);
                multi *= 2;
            } else if(c == '[') {
                stack.push(c);
                multi *= 3;
            } else if(c == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    sum = 0;
                    break;
                } else if(str.charAt(i - 1) == '(') {
                    sum += multi;
                }
                stack.pop();
                multi /= 2;
            } else if(c == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    sum = 0;
                    break;
                } else if(str.charAt(i - 1) == '[') {
                    sum += multi;
                }
                stack.pop();
                multi /= 3;
            }
        }
        if(!stack.isEmpty()) sum = 0;
        System.out.println(sum);
    }
}
