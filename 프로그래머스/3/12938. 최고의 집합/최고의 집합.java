import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if (n > s) {
            return new int[]{-1};
        }
    
        int num = s / n;
        
        Arrays.fill(answer, num);
        
        for(int i = 0; i < s % n; i++){
            answer[i]++;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}