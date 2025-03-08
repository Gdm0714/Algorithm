class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[]server = new int[players.length + k];
        
        for(int i = 0; i < players.length; i++){
            int need = players[i] / m;
            if(need > 0 && server[i] < need){
                int sub = need - server[i];
                answer += sub;
                for (int j = 0; j < k; j++) server[i + j] += sub;
                
            }
        }
        
        return answer;
    }
}