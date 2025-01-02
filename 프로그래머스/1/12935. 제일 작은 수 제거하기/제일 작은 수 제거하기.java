

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length - 1];
        
        if(arr.length <= 1){
            return new int[]{-1};
        }
        
        int minIdx = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(min > arr[i]){
                minIdx = i;
                min = arr[i];
            }
        }
        
        int idx = 0;
        for(int i = 0; i < arr.length; i++){
            if(i != minIdx){
                answer[idx++] = arr[i];
            }
        }
        
        
        return answer;
    }
}