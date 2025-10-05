#include <string>
#include <vector>
#include <cmath>

using namespace std;

string changeNum(int n, int k){
    if(n == 0) return "0";
    
    string answer = "";
    
    while(n > 0){
        answer = to_string(n % k) + answer;
        n /= k;
    }
    return answer;
}

bool isPrime(long long num){
    if(num < 2) return false;
    if(num == 2) return true;
    if(num % 2 == 0) return false;
    
    for(long long i = 3; i * i <= num; i += 2){
        if(num % i == 0) return false;
    }
    return true;
}

int solution(int n, int k) {
    int answer = 0;
    
    string changedNum = changeNum(n, k);
    
    string num = "";
    
    for(int i = 0; i < changedNum.length(); i++){
        if(changedNum[i] == '0'){
            if(!num.empty()){
                long long candidate = stoll(num);
                if(isPrime(candidate)){
                    answer++;
                }
                num = "";
            }
        }else{
            num += changedNum[i];
        }
    }
    
    if(!num.empty()){
        long long candidate = stoll(num);
        if(isPrime(candidate)){
            answer++;
        }
    }
    return answer;
}