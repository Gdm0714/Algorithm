class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int start = 1;
        int end = 100000;
        while(start <= end){
            int mid = (start + end) / 2;
            long sum = 0;
            boolean b = false;
            for(int i = 0; i < times.length; i++){
                if(diffs[i] < mid){
                    sum += times[i];
                }
                else{
                    int tmp = diffs[i] - mid;
                    sum += tmp * (times[i] + (i > 0 ? times[i - 1] : 0)) + times[i];
                }
                if(sum > limit){
                    b = true;
                    break;
                }
            }
            if(!b){
                answer = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return answer;
    }
}