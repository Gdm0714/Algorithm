class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int a = getArrGCD(arrayA);
        int b = getArrGCD(arrayB);
        
        if(a > 1 && !isDiv(arrayB, a)){
            answer = Math.max(answer, a);
        }
        if(b > 1 && !isDiv(arrayA, b)){
            answer = Math.max(answer, b);
        }
        
        return answer;
    }
    
    
    int getArrGCD(int[] arr){
        int gcd = arr[0];
        for(int i = 0; i < arr.length; i++){
            gcd = getGCD(gcd, arr[i]);
        }
        return gcd;
    }
    
    int getGCD(int a, int b){
        while(b != 0){
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
    
    boolean isDiv(int[] arr, int num){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % num == 0){
                return true;
            }
        }
        return false;
    }
}