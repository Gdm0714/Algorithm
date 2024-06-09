import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportMap = new HashMap<>();
        Map<String, Integer> reportCountMap = new HashMap<>();
        for (String r : report) {
            String[] split = r.split(" ");
            String reporter = split[0];
            String reported = split[1];
            reportMap.putIfAbsent(reporter, new HashSet<>());
            if (reportMap.get(reporter).add(reported)) {
                reportCountMap.put(reported, reportCountMap.getOrDefault(reported, 0) + 1);
            }
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            for (String reported : reportMap.getOrDefault(id_list[i], Collections.emptySet())) {
                if (reportCountMap.getOrDefault(reported, 0) >= k) {
                    answer[i]++;
                }
            }
        }
        return answer;
    }
}