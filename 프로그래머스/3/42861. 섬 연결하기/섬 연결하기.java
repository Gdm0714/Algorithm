import java.util.*;

class Solution {
    boolean[] visited;
    ArrayList<ArrayList<int []>> lists;
    
    public int solution(int n, int[][] costs) {        
        visited = new boolean[n];
        
        lists = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            lists.add(new ArrayList<>());
        }
        
        for(int i = 0; i < costs.length; i++){
            lists.get(costs[i][0]).add(new int[]{costs[i][1], costs[i][2]});
            lists.get(costs[i][1]).add(new int[]{costs[i][0], costs[i][2]});
           
        }
        
        int answer = prim(n);
        return answer;
    }
    
    int prim(int n){
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[] {0, 0});
        
        int sum = 0;
        int cnt = 0;
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];
            if(visited[node]) continue;
            visited[node] = true;
            sum += cost;
            cnt++;
            if(cnt == n) break;
            
            for(int[] i: lists.get(node)){
                int nextNode = i[0];
                int nextCost = i[1];
                if(!visited[nextNode]){
                    pq.offer(new int[]{nextNode, nextCost});
                }
            }
        }
        return sum;
    }
}