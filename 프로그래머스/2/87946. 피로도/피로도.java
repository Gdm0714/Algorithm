import java.util.*;

class Solution {

    public int solution(int k, int[][] dungeons) {
        
        boolean[] visited = new boolean[dungeons.length];
        int answer = dfs(k, dungeons, 0, visited);
        
        return answer;
    }
    static int dfs(int k, int[][] dungeons, int result, boolean[] visited) {
        int max = result;
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                int cnt = dfs(k - dungeons[i][1], dungeons, result + 1, visited);
                max = Math.max(max, cnt);
                visited[i] = false;
            }
        }
        return max;
    }
}