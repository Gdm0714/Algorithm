import java.util.*;

class Solution {
    List<int[]> moves = new ArrayList<>();
    
    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2);
        
        int[][] answer = new int[moves.size()][2];
        for (int i = 0; i < moves.size(); i++) {
            answer[i][0] = moves.get(i)[0];
            answer[i][1] = moves.get(i)[1];
        }
        
        return answer;
    }
    
    private void hanoi(int n, int from, int to, int aux) {
        if (n == 1) {
            moves.add(new int[]{from, to});
            return;
        }
        
        hanoi(n - 1, from, aux, to);
        
        moves.add(new int[]{from, to});
        
        hanoi(n - 1, aux, to, from);
    }
}