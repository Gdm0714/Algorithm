
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String s : skill_trees){
            int learning = 0;
            
            boolean b = true;
            for(char c : s.toCharArray()){
                int idx = skill.indexOf(c);
                if(idx == -1) continue;
                else if(idx == learning) learning++;
                else{
                    b = false;
                    break;
                }
            }
            if(b) answer++;
        }
        
        return answer;
    }
}