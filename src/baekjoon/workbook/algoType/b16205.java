package baekjoon.workbook.algoType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b16205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int type = Integer.parseInt(st.nextToken());
        String str = st.nextToken();

        StringBuilder sb = new StringBuilder();
        switch (type) {
            case 1:
                String snake1 = "";
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                        snake1 += ('_' + String.valueOf(str.charAt(i)).toLowerCase());
                    } else {
                        snake1 += str.charAt(i);
                    }
                }

                sb.append(str).append("\n");
                sb.append(snake1).append("\n");
                sb.append(String.valueOf(str.charAt(0)).toUpperCase() + str.substring(1));
                break;
            case 2:
                String camel = "";
                boolean toUpper = false;
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '_') {
                        toUpper = true;
                    } else {
                        if (toUpper) {
                            camel += String.valueOf(str.charAt(i)).toUpperCase();
                            toUpper = false;
                        } else {
                            camel += str.charAt(i);
                        }
                    }
                }

                sb.append(camel).append("\n");
                sb.append(str).append("\n");
                sb.append(String.valueOf(camel.charAt(0)).toUpperCase() + camel.substring(1));
                break;
            case 3:
                String snake2 = String.valueOf(str.charAt(0)).toLowerCase();
                for (int i = 1; i < str.length(); i++) {
                    if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                        snake2 += ('_' + String.valueOf(str.charAt(i)).toLowerCase());
                    } else {
                        snake2 += str.charAt(i);
                    }
                }

                sb.append(String.valueOf(str.charAt(0)).toLowerCase() + str.substring(1)).append("\n");
                sb.append(snake2).append("\n");
                sb.append(str);
                break;
        }
        System.out.print(sb);
    }
}