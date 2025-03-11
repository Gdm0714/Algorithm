import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i: works) pq.add(i);
        
        while(!pq.isEmpty() && n > 0){
            int max = pq.poll();
            if(max > 0){
                max--;
                n--;
                pq.add(max);
            }
        }
        
        long answer = 0;
        while(!pq.isEmpty()){
            answer += Math.pow(pq.poll(), 2);
        }
        return answer;
    }
}