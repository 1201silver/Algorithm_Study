package baekjoon.workbook.algoType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1966 {

    private static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i < t; i++) {
            queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); /* 문서 개수 */
            int m = Integer.parseInt(st.nextToken()); /* 궁금한 문서 위치 */

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                queue.offer(new int[] {j, Integer.parseInt(st.nextToken())}); /* 문서 위치, 중요도 */
            }
            sb.append(copy(m)).append("\n");
        }
        System.out.print(sb);
    }

    static int copy(int m) {
        int cnt = 0;

        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();

            boolean isMax = true;
            int i = 0;
            for(int[] q : queue) {
                if(tmp[1] < q[1]) {
                    isMax = false;
                    queue.offer(tmp);

                    for(int j = 0; j < i; j++) {
                        queue.offer(queue.poll());
                    }
                    break;
                }
                i++;
            }

            if(isMax) {
                cnt++;
                if(tmp[0] == m) break;
            }
        }
        return cnt;
    }
}
