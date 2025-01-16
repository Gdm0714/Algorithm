import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int start = 0;
        int end = 0;
        
        int minLength = Integer.MAX_VALUE;
        int sum = sequence[0];
        while(true){
            if(end >= sequence.length){
                break;
            }
            if (sum < k){
                end++;
                if(end >= sequence.length){
                        break;
                    }
                sum += sequence[end];
            }
            else if (sum > k){
                sum -= sequence[start];
                start++;
            }
            
            if(sum == k){
                if(minLength > end - start) {
                    minLength = end - start;
                    System.out.println(start + " " + end);
                    answer[0] = start;
                    answer[1] = end;
                    
                }
                end++;
                    if(end >= sequence.length){
                        break;
                    }
                    sum += sequence[end];
            }
        }
        
        return answer;
    }
}