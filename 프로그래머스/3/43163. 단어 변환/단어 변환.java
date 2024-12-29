import java.util.*;

class Solution {
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new boolean[words.length];
        if(!Arrays.asList(words).contains(target)) {
            return 0;
        }
        dfs(begin, target, words, 0);
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    static void dfs(String begin, String target, String[] words, int answer) {
        
        if(begin.equals(target)){
            min = Math.min(min, answer);
            return;
        }
        
        for(int i = 0; i < words.length; i++){
            
            int cnt = 0;
            for(int j = 0; j < begin.length(); j++){
                if(begin.charAt(j) == words[i].charAt(j)){
                    cnt++;
                }
            }
            
            if(cnt == begin.length() - 1 && !visited[i]){
                visited[i] = true;
                dfs(words[i], target, words, answer + 1);
                visited[i] = false;
            }
        }
    }
}