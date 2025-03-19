import java.util.*;

class Solution {
    boolean[] visited;
    ArrayList<String> answer;
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        answer = new ArrayList<>();
        dfs("ICN", "ICN", tickets, 0);
        Collections.sort(answer);
        
        return answer.get(0).split(" ");
    }
    
    void dfs(String start, String end, String[][] tickets, int cnt){
        if(cnt == tickets.length){
            answer.add(end);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(start)){
                visited[i] = true;
                dfs(tickets[i][1], end + " " + tickets[i][1], tickets, cnt + 1);
                visited[i] = false;
            }
        }
    }
}