class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int pos = 1;
        int idx = 0;
        
        while(pos <= n){
            if(idx < stations.length && pos >= stations[idx] - w){
                pos = stations[idx] + w + 1;
                idx++;
            }else{
                answer++;
                pos = pos + (w * 2) + 1;
            }
        }
        
        return answer;
    }
}