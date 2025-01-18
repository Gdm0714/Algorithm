class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        int[] weightCount = new int[1001];
        
        for (int weight : weights) {
            weightCount[weight]++;
        }
        
        for (int weight = 100; weight <= 1000; weight++) {
            if (weightCount[weight] == 0) continue;
            
            if (weightCount[weight] > 1) {
                answer += (long) weightCount[weight] * (weightCount[weight] - 1) / 2;
            }
            
            if (weight * 3 % 2 == 0 && weight * 3 / 2 <= 1000) {
                answer += (long) weightCount[weight] * weightCount[weight * 3 / 2];
            }
            
            if (weight * 2 <= 1000) {
                answer += (long) weightCount[weight] * weightCount[weight * 2];
            }
            
            if (weight * 4 % 3 == 0 && weight * 4 / 3 <= 1000) {
                answer += (long) weightCount[weight] * weightCount[weight * 4 / 3];
            }
        }
        
        return answer;
    }
}