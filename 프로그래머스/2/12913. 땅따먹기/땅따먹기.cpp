#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> land) {
    int n = land.size();
    
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < 4; j++) {
            int maxPrev = 0;
            for (int k = 0; k < 4; k++) {
                if (k != j) {
                    maxPrev = max(maxPrev, land[i-1][k]);
                }
            }
            land[i][j] += maxPrev;
        }
    }
    
    return *max_element(land[n-1].begin(), land[n-1].end());
}