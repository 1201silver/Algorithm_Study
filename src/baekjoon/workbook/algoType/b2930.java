package baekjoon.workbook.algoType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2930 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int r = Integer.parseInt(br.readLine());
        String sang = br.readLine();
        int n = Integer.parseInt(br.readLine());

        char friend[][] = new char[n][r];

        int score = 0;
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < r; j++) {
                friend[i][j] = str.charAt(j);
                score += game(sang.charAt(j), friend[i][j]);
            }
        }

        int res = 0;
        for(int i = 0; i < r; i++) {
            int scoreR = 0;
            int scoreS = 0;
            int scoreP = 0;
            int max = 0;
            for(int j = 0; j < n; j++) {
                scoreR += game('R', friend[j][i]);
                scoreS += game('S', friend[j][i]);
                scoreP += game('P', friend[j][i]);

                max = Math.max(scoreR, Math.max(scoreS, scoreP));
            }
            res += max;
        }
        System.out.print(score + "\n" + res);
    }

    static int game(char sang, char friend) {
        if(sang == friend) {
            return 1;
        } else {
            switch (sang) {
                case 'R':
                    return friend == 'S' ? 2 : 0;
                case 'S':
                    return friend == 'P' ? 2 : 0;
                case 'P':
                    return friend == 'R' ? 2 : 0;
                default:
                    return 0;
            }
        }
    }
}
