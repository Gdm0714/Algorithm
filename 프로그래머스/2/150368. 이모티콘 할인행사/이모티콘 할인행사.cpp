#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> diss = {10, 20, 30, 40};
vector<int> answer;

void calculate(vector<vector<int>>& users, vector<int>& emoticons, vector<int>& curDis){
    int plusCnt = 0;
    int sum = 0;
    
    for(auto& user: users){
        int userDis = user[0];
        int userMax = user[1];
        
        int userSum = 0;
        
        for(int i = 0; i < emoticons.size(); i++){
            int dis = curDis[i];
            if(dis >= userDis){
                int price = emoticons[i] * (100 - dis) / 100;
                userSum += price;
            }
        }
        if(userSum >= userMax) {
            plusCnt++;
        }else{
            sum += userSum;
        }
    }
    
    if(answer.empty() || plusCnt > answer[0] || (plusCnt == answer[0] && sum > answer[1])){
        answer = {plusCnt, sum};
    }
    
}

//백트래킹
void createDis(vector<vector<int>>& users, vector<int>& emoticons, vector<int>& curDis, int idx){
    if(idx == curDis.size()){
        calculate(users, emoticons, curDis);
        return;
    }
    
    for(int dis: diss){
        curDis[idx] = dis;
        createDis(users, emoticons, curDis, idx + 1);
    }
}

vector<int> solution(vector<vector<int>> users, vector<int> emoticons) {
    vector<int> curDis(emoticons.size());
    createDis(users, emoticons, curDis, 0);
    return answer;
}