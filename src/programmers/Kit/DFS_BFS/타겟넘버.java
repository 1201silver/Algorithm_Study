package programmers.Kit.DFS_BFS;

public class 타겟넘버 {

    static int cnt = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return cnt;
    }

    public void dfs(int[] numbers, int idx, int target, int sum) {
        if(idx == numbers.length) {
            if(sum == target) {
                cnt++;
            }
            return;
        }

        dfs(numbers, idx + 1, target, sum + numbers[idx]);
        dfs(numbers, idx + 1, target, sum - numbers[idx]);
    }
}
