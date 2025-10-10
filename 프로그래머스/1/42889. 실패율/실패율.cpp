#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    
    vector<int> failCnt(N + 2, 0);
    
    for(int s: stages){
        failCnt[s]++;
    }
    
    vector<pair<double, int>> failRate;
    
    int sum = stages.size();
    
    for(int s = 1; s <= N; s++) {
        if(sum == 0){
            failRate.push_back({0, s});
        }
        else{
            double rate = (double)failCnt[s] / sum;
            failRate.push_back({rate, s});
            
            sum -= failCnt[s];
        }
    }
    
    sort(failRate.begin(), failRate.end(), [](auto& a, auto& b){
        if(a.first == b.first){
            return a.second < b.second;
        }
        return a.first > b.first;
    });
    
    for(auto& p: failRate){
        answer.push_back(p.second);
    }
    return answer;
}