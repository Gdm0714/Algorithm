import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> completionMap = new HashMap<>();
        for (String name : completion) {
            completionMap.put(name, completionMap.getOrDefault(name, 0) + 1);
        }

        for (String name : participant) {
            if (!completionMap.containsKey(name) || completionMap.get(name) == 0) {
                return name;
            } else {
                completionMap.put(name, completionMap.get(name) - 1);
            }
        }

        return "";
    }
}