import java.util.*;

class Solution {
    boolean[][] visited;
    int n, m;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public ArrayList<Integer> solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        visited = new boolean[n][m];
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(maps[i].charAt(j) != 'X' && !visited[i][j]){
                    list.add(bfs(maps, i, j));
                }
            }
        }
        
        Collections.sort(list);
        if(list.size() == 0){
            list.add(-1);
        }
        return list;
    }
    
    int bfs(String[] maps, int i, int j){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;
        int sum = maps[i].charAt(j) - '0';
        
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            for(int k = 0; k < 4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]
                  && maps[nx].charAt(ny) != 'X'){
                    visited[nx][ny] = true;
                    sum += maps[nx].charAt(ny) - '0';
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return sum;
    }
}