import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
    
        String answer = "";

        int[][] keypad = {{0,0}, {0,0}, {0,1}, {0,2},
                          {1,0}, {1,1}, {1,2},
                          {2,0}, {2,1}, {2,2},
                          {3,0}, {3,1}, {3,2}};
        int[] left = keypad[10];
        int[] right = keypad[12];
        
        
        
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == 0) numbers[i] = 11;
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer += "L";
                left = keypad[numbers[i]];
            }
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer += "R";
                right = keypad[numbers[i]];
            }
            else{
                int leftDis = Math.abs(left[0] - keypad[numbers[i]][0]) + Math.abs(left[1] - keypad[numbers[i]][1]);
                int rightDis = Math.abs(right[0] - keypad[numbers[i]][0]) + Math.abs(right[1] - keypad[numbers[i]][1]);
                if(leftDis < rightDis){
                    answer += "L";
                    left = keypad[numbers[i]];
                }
                else if(rightDis < leftDis){
                    answer += "R";
                    right = keypad[numbers[i]];
                }else{
                    if(hand.equals("right")){
                        answer += "R";
                        right = keypad[numbers[i]];
                    }else{
                        answer += "L";
                        left = keypad[numbers[i]];
                    }
                }
            }
        }
        
        return answer;
    }
}