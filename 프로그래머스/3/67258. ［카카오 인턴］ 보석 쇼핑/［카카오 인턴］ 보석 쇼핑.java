import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        HashSet<String> set = new HashSet<>(Arrays.asList(gems));
        int start = 0;
        int end = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        int minStart = 0;
        int minEnd = gems.length;
        int min = gems.length + 1;
        
        while(true){
            if (map.size() == set.size()) {
                if (end - start < min) {
                    minStart = start;
                    minEnd = end - 1;
                    min = end - start;
                }
                
                map.put(gems[start], map.get(gems[start]) - 1);
                if(map.get(gems[start]) == 0) map.remove(gems[start]);
                start++;
            } else {
                if (end == gems.length) break;
                map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
                end++;
            }
        }
        
        return new int[]{minStart + 1, minEnd + 1};
    }
}