import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < operations.length; i++){
            StringTokenizer st = new StringTokenizer(operations[i]);
            String cmd = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            if(cmd.equals("I")) {
                minHeap.add(n);
                maxHeap.add(n);
            } else {
                if(minHeap.isEmpty()) continue;
                
                if(n == 1) {
                    int max = maxHeap.poll();
                    minHeap.remove(max);
                } else {
                    int min = minHeap.poll();
                    maxHeap.remove(min);
                }
            }
        }
        
        if(minHeap.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{maxHeap.peek(), minHeap.peek()};
        }
    }
}