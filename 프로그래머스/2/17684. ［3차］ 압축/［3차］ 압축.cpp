#include <string>
#include <vector>
#include <iostream>
#include <map>

using namespace std;

vector<int> solution(string msg) {
    vector<int> answer;
    int start = 27;
    map<string, int> words;
    
    for(int i = 0; i < 26; i++){
        words[string(1, 'A' + i)] = i + 1;
    }
    
    int idx = 27;
    int i = 0;
    while(i < msg.size()){
        string s = "";
        s += msg[i];
        
        while(i + s.length() < msg.size() && words.find(s + msg[i + s.length()]) != words.end()){
            s += msg[i + s.length()];
        }
        
        answer.push_back(words[s]);
        
        if(i + s.length() < msg.length()){
            char c = msg[i + s.length()];
            words[s + c] = idx++;
        }
        
        i += s.length();
    }
    
    return answer;
}