#include <string>
#include <vector>
#include <map>
#include <sstream>

using namespace std;

vector<string> solution(vector<string> record) {
    vector<string> answer;
    
    map<string, string> nickname;
    vector<pair<string, string>> inout;
    
    for(string r: record){
        stringstream ss(r);
        string s, id, nn;
        
        ss >> s >> id;
        
        if(s == "Enter" || s == "Change"){
            ss >> nn;
            nickname[id] = nn;
        }
        
        if(s != "Change"){
            inout.push_back({s, id});
        }
    }
    
    for(auto& a: inout){
        string s = a.first;
        string id = a.second;
        string nn = nickname[id];
        
        if(s == "Enter"){
            answer.push_back(nn + "님이 들어왔습니다.");
        }
        else if (s == "Leave"){
            answer.push_back(nn + "님이 나갔습니다.");
        }
    }
    return answer;
}