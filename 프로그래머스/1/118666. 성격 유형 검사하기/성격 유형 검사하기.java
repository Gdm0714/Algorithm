import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] type = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        
        for(char s : type) map.put(s, 0);
        
        for (int i = 0; i < survey.length; i++){
            if(choices[i] < 4){
                map.put(survey[i].charAt(0), map.get(survey[i].charAt(0)) + 4 - choices[i]);
            }
            else if(choices[i] > 4){
                map.put(survey[i].charAt(1), map.get(survey[i].charAt(1)) + choices[i] - 4);
            }
        }
        
        StringBuilder answer = new StringBuilder();
        answer.append(map.get('R') >= map.get('T') ? 'R' : 'T');
        answer.append(map.get('C') >= map.get('F') ? 'C' : 'F');
        answer.append(map.get('J') >= map.get('M') ? 'J' : 'M');
        answer.append(map.get('A') >= map.get('N') ? 'A' : 'N');
        
        return answer.toString();
    }
}