import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 1;
        
        int[][] tmp = new int[book_time.length][2];
        
        for(int i = 0; i < book_time.length; i++){
            StringTokenizer st = new StringTokenizer(book_time[i][0], ":");
            StringTokenizer st2 = new StringTokenizer(book_time[i][1], ":");
            tmp[i][0] = (Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken()));
            tmp[i][1] = (Integer.parseInt(st2.nextToken()) * 60 + Integer.parseInt(st2.nextToken())) + 10;
        }
        
        Arrays.sort(tmp, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < tmp.length; i++){
            if(!pq.isEmpty() && pq.peek() <= tmp[i][0]){
                pq.poll();
            }
            
            pq.add(tmp[i][1]);
        }
        
        return pq.size();
    }
}