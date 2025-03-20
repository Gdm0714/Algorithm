import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        int time = Integer.MAX_VALUE; 
        for(int i = 0; i < times.length; i++){
            time = Math.min(time, times[i]);
        }
        
        long start = 1;
        long end = (long)n * time;
        long answer = end;
        
        
        while(start <= end){
            long mid = (start + end) / 2;
            
            long cnt = 0;
            for(int i = 0; i < times.length; i++){
                cnt += mid / times[i];
                
                if(cnt >= n){
                    break;
                }
            }
            
            if(cnt >= n){
                answer = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        
        return answer;
    }
}