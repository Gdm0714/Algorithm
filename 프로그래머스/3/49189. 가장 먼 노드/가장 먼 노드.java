import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int[] e : edge) {
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        }
        
        int[] dis = new int[n + 1];
        Arrays.fill(dis, -1);
        dis[1] = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        
        while (!q.isEmpty()) {
            int current = q.poll();
            
            for (int next : list.get(current)) {
                if (dis[next] == -1) {
                    dis[next] = dis[current] + 1;
                    q.offer(next);
                }
            }
        }
        
        int max = 0;
        for (int i = 1; i <= n; i++) max = Math.max(max, dis[i]);
        
        
        for (int i = 1; i <= n; i++) {
            if (dis[i] == max) answer++;
            
        }
        
        return answer;
    }
}