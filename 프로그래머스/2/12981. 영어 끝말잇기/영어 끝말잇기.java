import java.util.*;
import java.lang.*;

class Solution {
    public double[] solution(int n, String[] words) {
        double[] answer = new double[2];
        
        Stack<String> list = new Stack<>();
        for(int i = 0; i < words.length; i++) {
            if (list.contains(words[i]) || list.size() > 0 && list.peek().charAt(list.peek().length()-1) != words[i].charAt(0)){
                double d = (i+1) / (double)n;
                
                answer[1] = Math.ceil(d);
                if ((i + 1) % n == 0){
                    answer[0] = n;
                }
                else {
                    answer[0] = (i + 1) % n;
                }
                
                break;
            }
            list.add(words[i]);
        }

        return answer;
    }
}