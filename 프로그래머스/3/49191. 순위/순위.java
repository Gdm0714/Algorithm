class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] b = new boolean[n + 1][n + 1];
        for(int[]i : results){
            b[i[0]][i[1]] = true;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= n; k++){
                    if(b[j][i] && b[i][k]){
                        b[j][k] = true;
                    }
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            int cnt = 0;
            for(int j = 1; j <= n; j++){
                if(i == j) continue;
                if(b[i][j] || b[j][i]){
                    cnt++;
                }
            }
            if(cnt == n - 1){
                answer++;
            }
        }
        
        return answer;
    }
}