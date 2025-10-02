#include <string>
#include <vector>
#include <map>

using namespace std;

vector<int> solution(vector<vector<int>> edges) {
    vector<int> answer;
    
    map<int, int> in;
    map<int, int> out;
    
    for(vector<int>& e: edges) {
        int start = e[0];
        int end = e[1];
        
        out[start]++;
        in[end]++;
        
        if(out.find(end) == out.end()){
            out[end] = 0;
        }
        if(in.find(start) == in.end()){
            in[start] = 0;
        }
    }
    
    int createNode = 0;
    int donut = 0;
    int stick = 0;
    int eight = 0;
    
    for(auto& p: out){
        int node = p.first;
        int outCnt = p.second;
        int inCnt = in[node];
        
        if(outCnt >= 2 && inCnt == 0){
            createNode = node;
        }
        
        else if(inCnt >= 2 && outCnt == 2){
            eight++;
        }
        
        else if(outCnt == 0){
            stick++;
        }
    }
    
    int sum = out[createNode];
    donut = sum - eight - stick;
    
    answer = {createNode, donut, stick, eight};
    return answer;
}