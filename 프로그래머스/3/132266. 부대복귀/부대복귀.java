import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            lists.add(new ArrayList<>());
        }
        
        for(int[] i: roads){
            lists.get(i[0]).add(i[1]);
            lists.get(i[1]).add(i[0]);
        }
        
        int[] d = new int[n + 1];
        
        Arrays.fill(d, -1);
        
        Queue<Integer> q = new LinkedList<>();
        q.add(destination);
        d[destination] = 0;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int i : lists.get(cur)){
                if(d[i] == -1){
                    d[i] = d[cur] + 1;
                    q.add(i);
                }
            }
        }
        
        for(int i = 0; i < sources.length; i++){
            answer[i] = d[sources[i]];
        }
        return answer;
    }
}