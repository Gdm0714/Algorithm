import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int [][] map;
    static int [][] dp;
    static int INF = 100_100_100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][1 << n];
        INF = 9999999;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(tsp(0, 1));
    }

    static int tsp(int id, int visited){
        if(visited == (1<<n)-1) {
            if (map[id][0] == 0) {
                return INF;
            }
            return map[id][0];
        }
        if (dp[id][visited] != 0) {
            return dp[id][visited];
        }
        dp[id][visited] = INF;
        for (int i = 0; i<n; i++) {
            int next = visited | (1<<i);
            if((visited & (1 << i)) != 0 ) continue;
            if(map[id][i]==0) continue;
            dp[id][visited] = Math.min(
                    dp[id][visited], tsp(i, next) + map[id][i]);
        }
        return dp[id][visited];
    }
}