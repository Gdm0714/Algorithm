#include <string>
#include <vector>
#include <set>
#include <sstream>

using namespace std;

vector<int> solution(vector<string> operations) {
    vector<int> answer;
    multiset<int> ms;
    
    for(string op: operations){
        stringstream ss(op);
        char cmd;
        int num;
        ss >> cmd >> num;
        
        if(cmd == 'I'){
            ms.insert(num);
        }else if(cmd == 'D' && !ms.empty()){
            if(num == 1){
                ms.erase(--ms.end());
            }else{
                ms.erase(ms.begin());
            }
        }
    }
    if(ms.empty()){
        return {0, 0};
    }else{
        return {*ms.rbegin(), *ms.begin()};
    }
}