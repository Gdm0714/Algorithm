import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            hm.put(genres[i], hm.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        Map<String, Map<Integer, Integer>> album = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            album.computeIfAbsent(genres[i], k -> new HashMap<>()).put(i, plays[i]);
        }

        List<String> sortingArr = hm.keySet().stream().sorted(Comparator.comparing(s -> hm.get(s)).reversed())
                                                .collect(Collectors.toList());
        List<Integer> answer = new ArrayList<>();

        for(String genre: sortingArr){
            Map<Integer, Integer> temp = album.get(genre);
            List<Integer> keys = temp.keySet()
                                           .stream()
                                           .sorted(Comparator.comparing(
                                                                 (Integer i) -> temp.get(i))
                                                             .reversed()
                                                             .thenComparing(i -> i))
                                           .limit(2)
                                           .collect(Collectors.toList());
            answer.addAll(keys);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}