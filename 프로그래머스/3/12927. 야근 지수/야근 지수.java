import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i: works){
            maxHeap.add(i);
        }
        
        while(!maxHeap.isEmpty() && n > 0){
            int max = maxHeap.poll();
            if(max > 0) {
                max--;
                n--;
                maxHeap.add(max);
            }
        }
        
        long answer = 0;
        while(!maxHeap.isEmpty()) {
            int max = maxHeap.poll();
            answer += Math.pow(max, 2);
        }
        return answer;
    }
}