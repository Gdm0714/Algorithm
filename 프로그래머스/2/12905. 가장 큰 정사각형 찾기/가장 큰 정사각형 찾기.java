import java.util.*;

class Solution
{
    public int solution(int [][]board)
    {
        int max = 0;
        int n = board.length;
        int m = board[0].length;
        
        
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(board[i][j] == 1){
                    board[i][j] = Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1]) + 1;
                    max = Math.max(max, board[i][j]);
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            max = Math.max(max, board[i][0]);
        }
        
        for(int i = 0; i < m; i++){
            max = Math.max(max, board[0][i]);
        }
        
        return max * max;
    }
}