#include <string>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

map<string, int> menuCnt;

void makeMenu(string order, string cur, int start, int size){
    if(cur.length() == size){
        menuCnt[cur]++;
        return;
    }
    
    for(int i = start; i < order.length(); i++){
        makeMenu(order, cur + order[i], i + 1, size);
    }
}

vector<string> solution(vector<string> orders, vector<int> course) {
    vector<string> answer;
    for(int c: course){
        menuCnt.clear();
        for(string order: orders){
            sort(order.begin(), order.end());
            
            if(order.length() >= c){
                makeMenu(order, "", 0, c);
            }
        }
        
        int max2 = 0;
        
        for(auto& cnt: menuCnt){
            if(cnt.second >= 2){
                max2 = max(max2, cnt.second);
            }
        }
        
        if(max2 >= 2){
            for(auto& cnt: menuCnt){
                if(cnt.second == max2){
                    answer.push_back(cnt.first);
                }
            }
        }
    }
    
    sort(answer.begin(), answer.end());
    return answer;
}