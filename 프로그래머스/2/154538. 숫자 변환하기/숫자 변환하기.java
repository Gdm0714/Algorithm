import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        boolean[] visited = new boolean[1000001];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, 0});
        visited[x] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int num = cur[0];
            int cnt = cur[1];

            if (num == y) return cnt;
            
            int[] nextNums = {num + n, num * 2, num * 3};

            for (int next : nextNums) {
                if (next <= 1000000 && !visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, cnt + 1});
                }
            }
        }
        return -1;
    }
}
