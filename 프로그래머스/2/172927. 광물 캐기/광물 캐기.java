import java.util.*;

class Solution {
    static int[][] fatigue = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
    public int solution(int[] picks, String[] minerals) {
        int total = picks[0] + picks[1] + picks[2];
        int g = Math.min(total, (minerals.length + 4) / 5);
        int[][] f = new int[g][3];
        
        for(int i = 0; i < g; i++){
            int start = i * 5;
            int end = Math.min(start + 5, minerals.length);
            for(int j = start; j < end; j++){
                int idx = 0;
                if(minerals[j].equals("diamond")) idx = 0;
                else if(minerals[j].equals("iron")) idx = 1;
                else idx = 2;
                f[i][0] += fatigue[0][idx];
                f[i][1] += fatigue[1][idx];
                f[i][2] += fatigue[2][idx];
            }
            
        }
        
        return dfs(picks, f, 0, new boolean[g]);
    }
    
    static int dfs(int[] picks, int[][] f, int cnt, boolean[] visited){
        if(cnt == f.length) return 0;
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < 3; i++){
            if(picks[i] > 0){
                picks[i]--;
            
                for(int j = 0; j < f.length; j++){
                    if(!visited[j]){
                        visited[j] = true;
                        int fg = f[j][i] + dfs(picks, f, cnt + 1, visited);
                        min = Math.min(fg, min);
                        visited[j] = false;
                        break;
                    }
                }
                picks[i]++;
            }
            
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}