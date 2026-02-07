#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    
    if(n == 1) return 1;
    if(n == 2) return 2;
    
    const int div = 1000000007;
    vector<long long> dp(n + 1);
    dp[1] = 1;
    dp[2] = 2;
    for(int i = 3; i <= n; i++){
        dp[i] = (dp[i-1] + dp[i-2])%div;
    }
    return dp[n];
}