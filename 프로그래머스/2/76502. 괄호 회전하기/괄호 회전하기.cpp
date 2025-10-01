#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int answer = 0;
    int len = s.length();
    
    for(int x = 0; x < len; x++){
        vector<char> stack;
        bool isValid = true;
        
        for(int i = 0; i < len; i++){
            char c = s[(x + i) % len];
            
            if(c == '(' || c== '[' || c == '{'){
                stack.push_back(c);
            }else{
                if(stack.empty()){
                    isValid = false;
                    break;
                }
                char top = stack.back();
            
            if((c==')' && top == '(')||(c=='}' && top == '{')||(c==']' && top == '[')){
                stack.pop_back();
            }else{
                isValid = false;
                break;
            }
            }
            
        }
        if(isValid && stack.empty()){
            answer++;
        }
    }
    return answer;
}