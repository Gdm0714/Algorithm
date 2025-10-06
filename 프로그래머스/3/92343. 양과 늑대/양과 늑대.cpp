#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int maxSheep = 0;
vector<vector<int>> tree;

void dfs(int start, vector<int>& info, vector<bool>& visited, vector<int>& canVisit, int sheep, int wolf){
    visited[start] = true;
    
    if(info[start] == 0){
        sheep++;
    }else{
        wolf++;
    }
    
    if(sheep <= wolf){
        return;
    }
    
    maxSheep = max(maxSheep, sheep);
    
    vector<int> nextVisit;
    for(int next: canVisit){
        if(next != start) {
            nextVisit.push_back(next);
        }
    }
    
    for(int i: tree[start]) {
        if(!visited[i]){
            nextVisit.push_back(i);
        }
    }
    
    for(int i: nextVisit){
        if(!visited[i]){
            vector<bool> newVisited = visited;
            dfs(i, info, newVisited, nextVisit, sheep, wolf);
        }
    }
}

int solution(vector<int> info, vector<vector<int>> edges) {
    tree.resize(info.size());
    
    for(auto& edge: edges){
        tree[edge[0]].push_back(edge[1]);
    }
    
    vector<bool> visited(info.size(), false);
    vector<int> canVisit = {0};
    
    dfs(0, info, visited, canVisit, 0, 0);
    return maxSheep;
}