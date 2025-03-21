import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[1])
        );
        
        int cnt = 0;
        int cur = 0;
        int idx = 0;
        
        while(cnt < jobs.length) {
            while(idx < jobs.length && cur >= jobs[idx][0]){
                pq.add(jobs[idx]);
                idx++;
            }
            
            if(!pq.isEmpty()){
                int[] job = pq.poll();
                answer += cur - job[0] + job[1];
                cur += job[1];
                cnt++;
            }else{
                cur = jobs[idx][0];
            }
        }
        
        return answer / jobs.length;
    }
}