import java.util.*;

class Solution {
    HashSet<String> set = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        String[] s = new String[banned_id.length];
        for (int i = 0; i < banned_id.length; i++) {
            s[i] = banned_id[i].replace("*", ".");
        }
        
        boolean[] visited = new boolean[user_id.length];
        dfs(user_id, s, visited, 0, "");
        
        return set.size();
    }
    
    private void dfs(String[] user_id, String[] s, boolean[] visited, int depth, String result) {
        if (depth == s.length) {
            String[] arr = result.split(" ");
            Arrays.sort(arr);
            set.add(String.join("", arr));
            return;
        }
        
        for (int i = 0; i < user_id.length; i++) {
            if (!visited[i] && user_id[i].matches(s[depth])) {
                visited[i] = true;
                dfs(user_id, s, visited, depth + 1, result + user_id[i] + " ");
                visited[i] = false;
            }
        }
    }
}