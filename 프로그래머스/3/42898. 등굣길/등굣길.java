class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int [][] map = new int[n][m];
        map[0][0] = 1;
        for(int i[] : puddles){
            map[i[1] - 1][i[0] - 1] = -1;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == -1){
                    map[i][j] = 0;
                    continue;
                }
                if (i > 0){
                    map[i][j] += map[i - 1][j];
                }
                if (j > 0){
                    map[i][j] += map[i][j - 1];
                }
                
                map[i][j] %= 1000000007;
            }
        }
        
        return map[n - 1][m - 1];
    }
}