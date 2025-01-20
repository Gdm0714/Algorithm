import java.util.*;

class Solution {
    boolean[] visited;
    ArrayList<String> list;
    public String[] solution(String[][] tickets) {
        list = new ArrayList<>();
        visited = new boolean[tickets.length];
        dfs("ICN", tickets, "ICN", 0);
        Collections.sort(list);
        
        return list.get(0).split(" ");
    }
    
    void dfs(String start, String[][] tickets, String end, int cnt){
        if(cnt == tickets.length){
            list.add(end);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(start)){
                visited[i] = true;
                dfs(tickets[i][1], tickets, end + " " + tickets[i][1], cnt + 1);
                visited[i] = false;
            }
        }
    }
}