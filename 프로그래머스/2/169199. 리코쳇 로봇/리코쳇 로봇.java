import java.util.*;

class Solution {
    int[]dx = {-1, 1, 0, 0};
    int[]dy = {0, 0, -1, 1};
    boolean[][][] visited;
    int n, m, startX, startY, endX, endY;
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        startX = 0;
        startY = 0;
        endX = 0;
        endY = 0;
        
        visited = new boolean[n][m][4];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    startX = i;
                    startY = j;
                } else if (board[i].charAt(j) == 'G') {
                    endX = i;
                    endY = j;
                }
            }
        }
        return bfs(board);
    }
    
    int bfs(String[] board){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY, -1, 0});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dir = cur[2];
            int dis = cur[3];
            
            if(x == endX && y == endY) return dis;
            
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (i == dir) continue;
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m 
                   && board[nx].charAt(ny) != 'D'){
                    int moveX = x;
                    int moveY = y;
                    while(true){
                        int nnx = moveX + dx[i];
                        int nny = moveY + dy[i];
                        if(nnx < 0 || nnx >= n || nny < 0 || nny >= m
                          || board[nnx].charAt(nny) == 'D') break;
                        
                        moveX = nnx;
                        moveY = nny;
                    }
                    
                    if(!visited[moveX][moveY][i]){
                        visited[moveX][moveY][i] = true;
                        q.add(new int[]{moveX, moveY, i, dis + 1});
                    }
                }
            }
        }
        return -1;
    }
}