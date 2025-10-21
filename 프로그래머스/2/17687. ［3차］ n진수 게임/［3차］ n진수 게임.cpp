#include <string>
#include <vector>

using namespace std;

string solution(int n, int t, int m, int p) {
    string answer = "";
    string calculatedResult = "";
    
    auto change = [&](int num, int base) -> string {
        if(num == 0) return "0";
        string result = "";
        
        while(num > 0){
            int num2 = num % base;
            if(num2 < 10){
                result = char('0' + num2) + result;
            }else{
                result = char('A' + num2 - 10) + result;
            }
            num /= base;
        }
        return result;
    };
            int num3 = 0;
        
        for(int i = 0; i < t * m; i++){
            calculatedResult += change(num3, n);
            num3++;
        }
        
        for(int i = 0; i < t; i++){
            int idx = i * m + (p - 1);
            answer += calculatedResult[idx];
        }
    return answer;
}