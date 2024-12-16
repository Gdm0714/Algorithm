import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int l = tangerine.length;
        int[] cnt = new int[10000001];
        for(int i = 0; i < l; i++){
            cnt[tangerine[i]]++;
        }
        Arrays.sort(cnt);
        int sum = 0;
        for(int i = 10000000; i >= 0; i--){
            answer++;
            if(cnt[i] != 0){
                sum += cnt[i];
            }
            if(sum >= k) {
                break;
            }
        }
        
        return answer;
    }
}