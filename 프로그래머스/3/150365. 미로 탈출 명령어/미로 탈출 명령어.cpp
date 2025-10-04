#include <string>
#include <vector>

using namespace std;

string solution(int n, int m, int x, int y, int r, int c, int k) {
    int dir[] = {'d', 'l', 'r', 'u'}; // 사전순으로 정렬
    int dx[] = {1, 0, 0, -1};
    int dy[] = {0, -1, 1, 0};
    int min = abs(x - r) + abs(y - c);
    
    // k가 최단거리보다 작으면 이동 불가, k가 홀수면 최단거리만큼 이동하고 왔다갔다 2번 해야하는데 가기만 하면 도착불가
    if(k < min || (k - min) %2 == 1){
        return "impossible";
    }
    
    string answer = "";
    
    int cX = x;
    int cY = y;
    int cnt = k;
    
    while(cnt > 0){
        bool canMove = false;
        
        for(int i = 0; i < 4; i++){
            int nx = cX + dx[i];
            int ny = cY + dy[i];
            
            if(nx <= 0 || nx > n || ny <= 0 || ny > m) continue;
            
            int dist = abs(nx - r) + abs(ny - c);
            int cntAfterMove = cnt - 1;
            
            if(dist <= cntAfterMove && (cntAfterMove - dist) % 2 == 0){
                answer += dir[i];
                cX = nx;
                cY = ny;
                cnt--;
                canMove = true;
                break;
            }
        }
        if(!canMove){
            return "impossible";
        }
    }
    return answer;
}