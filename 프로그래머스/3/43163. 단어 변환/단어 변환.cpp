#include <string>
#include <vector>
#include <queue>

using namespace std;

bool isOneDiff(string a, string b){
    int diff = 0;
    for(int i = 0; i < a.length(); i++){
        if(a[i] != b[i]){
            diff++;
        }
    }
    return diff == 1;
}

int solution(string begin, string target, vector<string> words) {
    int answer = 0;
    bool hasTarget = false;
    for(string w: words){
        if(w == target){
            hasTarget = true;
            break;
        }
    }
    
    if(!hasTarget){
        return 0;
    }
    
    queue<pair<string, int>> q;
    vector<bool> visited(words.size(), false);
    
    q.push({begin, 0});
    
    while(!q.empty()){
        string cur = q.front().first;
        int cnt = q.front().second;
        q.pop();
        
        if(cur == target){
            return cnt;
        }
        
        for(int i = 0; i < words.size(); i++){
            if(!visited[i] && isOneDiff(cur, words[i])){
                visited[i] = true;
                q.push({words[i], cnt + 1});
            }
        }
    }
    return 0;
}