class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int start = 0;
        int end = 200000000;
        
        while(start <= end){
            int mid = (start + end) / 2;
            if(isCan(stones, k, mid)){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        
        return end;
    }
    
    boolean isCan(int[] stones, int k, int people){
        int cnt = 0;
        for(int i = 0; i < stones.length; i++){
            if(stones[i] - people < 0){
                cnt++;
            } else {
                cnt = 0;
            }
            
            if(cnt >= k){
                return false;
            }
        }
        return true;
    }
}